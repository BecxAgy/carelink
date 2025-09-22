package com.ws.carelink.infra.out.persistence.jpa.user.springdata;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.carelink.core.domain.user.User;
import com.ws.carelink.shared.exception.ObjetoNaoEncontradoException;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email) throws ObjetoNaoEncontradoException;
    
}
