package com.ws.carelink.core.application.service.auth;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ws.carelink.core.application.command.auth.RefreshTokenCommand;
import com.ws.carelink.core.application.command.auth.SignInCommand;
import com.ws.carelink.core.application.command.auth.SignUpCommand;
import com.ws.carelink.core.application.representation.auth.JwtAuthRepresentation;
import com.ws.carelink.core.application.representation.user.UserRepresentation;
import com.ws.carelink.core.application.usecase.auth.AuthUseCase;
import com.ws.carelink.core.application.usecase.jwt.JwtUseCase;
import com.ws.carelink.core.domain.user.User;
import com.ws.carelink.core.repository.user.UserRepository;
import com.ws.carelink.shared.exception.AuthenticationException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements AuthUseCase {

    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUseCase jwtUseCase;

    @Override
    public UserRepresentation signUp(SignUpCommand command) {
        User user = command.toUser(passwordEncoder);
        userRepository.add(user);

        return UserRepresentation.toRepresentation(user);
    }


    @Override
    public JwtAuthRepresentation signIn(SignInCommand command) {        
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(command.email(), command.password()));
            
        } catch (Exception e) {
            log.error("Authentication failed for user: {}", command.email(), e);
            throw e;
        }

        var user = userRepository.findByUsername(command.email());
        
        String token = jwtUseCase.generateToken(user);
        String refreshToken = jwtUseCase.generateRefreshToken(user, new HashMap<>());

        return new JwtAuthRepresentation(token, refreshToken);
    }
 
    @Override
    public JwtAuthRepresentation refreshToken(RefreshTokenCommand command) {
        String username = jwtUseCase.extractUsername(command.refreshToken());
        User user = userRepository.findByUsername(username);

        if (!jwtUseCase.isTokenValid(command.refreshToken(), user)) {
            throw new AuthenticationException("Invalid refresh token");
        }

        String token = jwtUseCase.generateToken(user);

        return new JwtAuthRepresentation(token, command.refreshToken());
    }
    
}
