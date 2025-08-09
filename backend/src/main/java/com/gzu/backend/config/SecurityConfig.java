package com.gzu.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final RestAuthenticationEntryPoint authenticationEntryPoint;
    private final RestAccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter, 
                         RestAuthenticationEntryPoint authenticationEntryPoint, 
                         RestAccessDeniedHandler accessDeniedHandler) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 为无状态的REST API禁用CSRF保护
                .csrf(AbstractHttpConfigurer::disable)
                // 配置请求授权规则
                .authorizeHttpRequests(auth -> auth
                        // 允许所有/api/auth/**下的请求
                        .requestMatchers("/api/auth/**").permitAll()
                        // 允许对统计接口的访问，具体权限由方法注解控制
                        .requestMatchers("/api/stats/**").permitAll()
                        // 允许对上传后的文件进行公开访问
                        .requestMatchers("/uploads/**").permitAll()
                        // 允许文件上传接口公开访问，以支持注册前上传头像
                        .requestMatchers("/api/upload/**").permitAll()
                        // 允许AI聊天接口（需要认证但在这里先允许，由过滤器处理）
                        .requestMatchers("/api/ai/**").authenticated()
                        // 其他所有请求都需要认证
                        .anyRequest().authenticated()
                )
                // 设置Session管理策略为无状态
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 添加异常处理器
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler)
                )
                // 在UsernamePasswordAuthenticationFilter之前添加我们的JWT过滤器
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}