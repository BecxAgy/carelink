package com.ws.carelink.core.application.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ws.carelink.core.application.usecase.user.UserUseCase;
import com.ws.carelink.core.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService  implements UserUseCase {

    private final UserRepository userRepository;


    @Override
    public UserDetails getUserById(Long id) {
        return userRepository.get(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
}
