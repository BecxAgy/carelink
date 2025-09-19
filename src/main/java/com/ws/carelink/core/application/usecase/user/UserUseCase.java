package com.ws.carelink.core.application.usecase.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserUseCase {
    UserDetails getUserByUsername(String username);
    UserDetails getUserById(Long id);
    
}
