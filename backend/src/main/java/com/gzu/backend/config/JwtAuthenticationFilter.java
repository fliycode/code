package com.gzu.backend.config;

import com.gzu.backend.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        System.out.println("=== JWT Filter Processing: " + requestURI + " ===");
        
        final String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization header: " + (authHeader != null ? "Bearer ***" : "null"));
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            System.out.println("JWT token extracted, length: " + jwt.length());
            
            try {
                Authentication auth = jwtUtil.getAuthentication(jwt);
                if (auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    System.out.println("Authentication set successfully for user: " + auth.getName());
                } else {
                    System.out.println("Authentication failed: getAuthentication returned null");
                }
            } catch (Exception e) {
                System.out.println("JWT token validation failed: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No Bearer token found in Authorization header");
        }
        
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Current authentication before filter chain: " + 
            (currentAuth != null ? currentAuth.getName() + " (authenticated: " + currentAuth.isAuthenticated() + ")" : "null"));
        
        filterChain.doFilter(request, response);
        
        System.out.println("=== JWT Filter Completed: " + requestURI + " ===");
    }
}