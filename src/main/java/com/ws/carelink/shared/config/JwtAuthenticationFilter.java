package com.ws.carelink.shared.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;


import com.ws.carelink.core.application.usecase.jwt.JwtUseCase;
import com.ws.carelink.core.application.usecase.user.UserUseCase;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtUseCase jwtUsecase;
    private final UserUseCase userUsecase;

    public JwtAuthenticationFilter(JwtUseCase jwtUsecase, UserUseCase userUsecase) {
        this.jwtUsecase = jwtUsecase;
        this.userUsecase = userUsecase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if (!authHeader.isEmpty() && authHeader.startsWith("Bearer ")) {
           filterChain.doFilter(request, response);
           return;      
        }

        jwt = authHeader.substring(7);
        userEmail = jwtUsecase.extractUsername(jwt);

        if(!userEmail.isBlank() && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userUsecase.getUserByUsername(userEmail);

            if(jwtUsecase.isTokenValid(jwt, userDetails)){
                SecurityContext context = SecurityContextHolder.createEmptyContext();

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }

        }

        filterChain.doFilter(request, response);

    }
    
}
