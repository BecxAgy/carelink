package com.ws.carelink.infra.out.persistence.user.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.carelink.core.domain.user.User;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    
}
