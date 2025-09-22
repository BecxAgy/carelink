package com.ws.carelink.core.application.command.auth;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.ws.carelink.core.domain.user.User;

public record SignUpCommand (String email, String name,String password) {

    public User toUser(PasswordEncoder passwordEncoder){
      return new User(email, name, passwordEncoder.encode(password));    
    }
    
}
