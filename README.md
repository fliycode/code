# 智能客服系统 - SSE认证修复版

## 项目描述

这是一个基于Spring Boot后端和Vue.js前端的智能客服系统，支持流式对话响应（SSE）。

## 修复的关键问题

### 原问题
在SSE流式响应中遇到Spring Security认证异常：
```
jakarta.servlet.ServletException: Unable to handle the Spring Security Exception because the response is already committed.
```

### 解决方案

1. **JWT过滤器修复**
   - 移除了错误的静态方法调用 `JwtUtil.setAuthentication(auth)`
   - 直接使用 `SecurityContextHolder.getContext().setAuthentication(auth)`
   - 添加详细的调试日志

2. **ChatController改进**
   - 使用 `SseEmitter` 替代 `Flux<String>` 来更好地处理SSE流
   - 在响应开始前验证认证状态
   - 异步处理聊天请求，避免阻塞主线程
   - 添加完善的错误处理机制

3. **SecurityConfig清理**
   - 移除重复的过滤器注入
   - 明确配置API路径的安全规则

4. **前端优化**
   - 改进EventSource的错误处理
   - 添加调试日志
   - 优化token传递方式

## 项目结构

```
├── backend/
│   └── src/main/java/com/gzu/backend/
│       ├── controller/
│       │   └── ChatController.java          # SSE流式对话控制器
│       ├── config/
│       │   ├── JwtAuthenticationFilter.java # JWT认证过滤器
│       │   └── SecurityConfig.java          # Spring Security配置
│       └── util/
│           └── JwtUtil.java                 # JWT工具类
└── frontend/
    └── src/components/
        └── ChatNavbar.vue                   # 智能客服Vue组件
```

## 关键技术点

### 后端技术
- Spring Boot 3.x
- Spring Security 6.x
- Spring AI (ChatClient)
- JWT认证
- Server-Sent Events (SSE)

### 前端技术
- Vue 3
- Element Plus
- EventSourcePolyfill
- 可拖拽、可缩放对话框

## 使用方法

1. 确保后端配置了正确的JWT密钥和过期时间
2. 前端需要在localStorage中存储有效的JWT token
3. 点击"智能客服"按钮打开对话框
4. 输入问题并发送，系统将通过SSE流式返回AI响应

## 调试功能

### 后端调试
- JWT过滤器会输出详细的认证流程日志
- ChatController会记录每次请求的处理过程

### 前端调试
- 浏览器控制台会显示EventSource的连接状态
- 显示token的存在状态和SSE事件接收情况

## 注意事项

1. 确保JWT token格式正确且未过期
2. 检查Spring Security配置是否允许对应的API路径
3. 确保AI服务配置正确（Spring AI ChatClient）
4. 注意CORS配置，特别是在跨域环境下