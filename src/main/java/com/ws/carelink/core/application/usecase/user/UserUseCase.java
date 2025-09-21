package com.ws.carelink.core.application.usecase.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserUseCase extends UserDetailsService {
    UserDetails getUserById(Long id);   
}
