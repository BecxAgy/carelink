package com.ws.carelink.core.application.usecase.auth;

import com.ws.carelink.core.application.command.auth.RefreshTokenCommand;
import com.ws.carelink.core.application.command.auth.SignInCommand;
import com.ws.carelink.core.application.command.auth.SignUpCommand;
import com.ws.carelink.core.application.representation.auth.JwtAuthRepresentation;
import com.ws.carelink.core.application.representation.user.UserRepresentation;

public interface AuthUseCase {

    UserRepresentation signUp(SignUpCommand command);
    JwtAuthRepresentation signIn(SignInCommand command); 
    JwtAuthRepresentation refreshToken(RefreshTokenCommand refreshToken);
}
