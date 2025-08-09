package com.gzu.backend.config;

import com.gzu.backend.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        // We DO want to filter on async dispatch to keep SecurityContext during SSE
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        // Filter on error dispatch as well to ensure context during error handling
        return false;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            try {
                Authentication auth = jwtUtil.getAuthentication(jwt);
                if (auth != null) {
                    JwtUtil.setAuthentication(auth);
                }
            } catch (Exception ignored) {
                // Let Spring Security handle unauthenticated state
            }
        }
        filterChain.doFilter(request, response);
    }
}