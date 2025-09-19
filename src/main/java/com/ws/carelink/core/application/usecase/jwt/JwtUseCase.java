package com.ws.carelink.core.application.usecase.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtUseCase {
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    public String generateToken(UserDetails userDetails, Claims extraClaims);
}
