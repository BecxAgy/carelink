package com.ws.carelink.core.application.usecase.auth;

import com.ws.carelink.core.application.command.SignInCommand;
import com.ws.carelink.core.application.command.SignUpCommand;
import com.ws.carelink.core.application.representation.UserRepresentation;

public interface AuthUseCase {

    UserRepresentation signUp(SignUpCommand command);
    UserRepresentation signIn(SignInCommand command); 
}
