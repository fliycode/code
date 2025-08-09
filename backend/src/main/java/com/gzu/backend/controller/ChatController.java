package com.gzu.backend.controller;

import com.gzu.backend.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/ai")
public class ChatController {

    private final ChatClient chatClient;
    private final JwtUtil jwtUtil;

    public ChatController(ChatClient.Builder builder, JwtUtil jwtUtil) {
        this.chatClient = builder
                .defaultSystem("""
                        ##角色
                        你是"途迹快递"的聊天支持代理,负责协同管理员进行业务管理.
                        你正在通过在线聊天系统与用户互动
                        ##需求
                        1.在涉及增删改（除了查询）function-call前，必须等用户回复"确认"再调用tool.
                        2.说中文.
                        今天的日期是 {current_date}.
                        """)
                .build();
        this.jwtUtil = jwtUtil;
    }

    @GetMapping(value="/generateStreamAsString", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter generateStreamAsString(
            @RequestParam(value = "message", defaultValue = "讲个笑话") String message,
            HttpServletRequest request,
            HttpServletResponse response) {

        System.out.println("=== ChatController called ===");
        
        // 手动验证认证状态
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication in controller: " + 
            (authentication != null ? authentication.getName() + " (authenticated: " + authentication.isAuthenticated() + ")" : "null"));
        
        // 如果认证失败，立即返回错误
        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("Authentication failed - returning error emitter");
            SseEmitter errorEmitter = new SseEmitter(30000L);
            try {
                errorEmitter.send(SseEmitter.event()
                    .data("认证失败，请重新登录")
                    .name("error"));
                errorEmitter.complete();
            } catch (IOException e) {
                errorEmitter.completeWithError(e);
            }
            return errorEmitter;
        }

        // 设置响应头
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Connection", "keep-alive");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Authorization");

        String username = authentication.getName();
        System.out.println("Processing request for user: " + username);

        // 创建 SseEmitter
        SseEmitter emitter = new SseEmitter(60000L); // 60秒超时

        // 异步处理聊天请求
        CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Starting chat stream for message: " + message);
                
                chatClient.prompt().user(message)
                    .system(p -> p.param("current_date", LocalDate.now()))
                    .stream().content()
                    .doOnNext(content -> {
                        try {
                            emitter.send(SseEmitter.event().data(content));
                        } catch (IOException e) {
                            System.err.println("Error sending SSE data: " + e.getMessage());
                            emitter.completeWithError(e);
                        }
                    })
                    .doOnComplete(() -> {
                        System.out.println("Chat stream completed");
                        emitter.complete();
                    })
                    .doOnError(error -> {
                        System.err.println("Chat stream error: " + error.getMessage());
                        try {
                            emitter.send(SseEmitter.event()
                                .data("服务暂时不可用，请稍后重试")
                                .name("error"));
                        } catch (IOException e) {
                            System.err.println("Error sending error message: " + e.getMessage());
                        }
                        emitter.completeWithError(error);
                    })
                    .subscribe();
                    
            } catch (Exception e) {
                System.err.println("Unexpected error in chat processing: " + e.getMessage());
                e.printStackTrace();
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }
}