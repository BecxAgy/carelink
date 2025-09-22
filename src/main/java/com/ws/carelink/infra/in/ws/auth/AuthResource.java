package com.ws.carelink.infra.in.ws.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.carelink.core.application.command.auth.RefreshTokenCommand;
import com.ws.carelink.core.application.command.auth.SignInCommand;
import com.ws.carelink.core.application.command.auth.SignUpCommand;
import com.ws.carelink.core.application.representation.auth.JwtAuthRepresentation;
import com.ws.carelink.core.application.representation.user.UserRepresentation;
import com.ws.carelink.core.application.usecase.auth.AuthUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthUseCase authUseCase;

    @PostMapping("/signup")
    public ResponseEntity<UserRepresentation> signUp(@RequestBody SignUpCommand command){     
        return ResponseEntity.ok(authUseCase.signUp(command));
    }


    @PostMapping("/signin")
    public ResponseEntity<JwtAuthRepresentation> signIn(@RequestBody SignInCommand command){
        return ResponseEntity.ok(authUseCase.signIn(command));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<JwtAuthRepresentation> refreshToken(@RequestBody RefreshTokenCommand refreshToken){
        return ResponseEntity.ok(authUseCase.refreshToken(refreshToken));
    }
 
    
}
