package com.ws.carelink.core.repository.user;

import com.ws.carelink.core.domain.user.User;
import com.ws.carelink.core.repository.Repository;

public interface UserRepository extends Repository<User, Long>{
    User findByUsername(String username);
    
}
