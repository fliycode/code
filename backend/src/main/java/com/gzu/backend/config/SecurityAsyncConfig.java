package com.gzu.backend.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class SecurityAsyncConfig {

    @PostConstruct
    public void enableInheritableSecurityContext() {
        // Ensure SecurityContext is inherited by child threads (e.g., async/SSE processing)
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
}