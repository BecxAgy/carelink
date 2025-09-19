package com.ws.carelink.core.application.service.impl.user;

import org.springframework.security.core.userdetails.UserDetails;

import com.ws.carelink.core.application.usecase.user.UserUseCase;
import com.ws.carelink.core.repository.user.UserRepository;

public class UserService  implements UserUseCase {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails getUserByUsername(String username) {    
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails getUserById(Long id) {
        return userRepository.get(id);
    }
    
}
