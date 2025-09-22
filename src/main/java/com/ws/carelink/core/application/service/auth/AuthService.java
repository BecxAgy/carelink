package com.ws.carelink.core.application.service.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ws.carelink.core.application.command.SignInCommand;
import com.ws.carelink.core.application.command.SignUpCommand;
import com.ws.carelink.core.application.representation.UserRepresentation;
import com.ws.carelink.core.application.usecase.auth.AuthUseCase;
import com.ws.carelink.core.domain.user.User;
import com.ws.carelink.core.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {

    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRepresentation signUp(SignUpCommand command) {
        User user = command.toUser(passwordEncoder);
        userRepository.add(user);

        return UserRepresentation.toRepresentation(user);
    }


    @Override
    public UserRepresentation signIn(SignInCommand command) {

        return null;
    }
    
}
