package com.example.metaphorce.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response,
                       final AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String errorMessage = "Acceso denegado: " + accessDeniedException.getMessage();

        response.sendError(HttpServletResponse.SC_FORBIDDEN, errorMessage);
    } //close method
} //close class
