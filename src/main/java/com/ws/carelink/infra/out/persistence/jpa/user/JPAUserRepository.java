package com.ws.carelink.infra.out.persistence.jpa.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ws.carelink.core.domain.user.User;
import com.ws.carelink.core.repository.user.UserRepository;
import com.ws.carelink.infra.out.persistence.jpa.user.springdata.SpringDataUserRepository;
import com.ws.carelink.shared.exception.ObjetoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JPAUserRepository implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public void add(User obj) {
        springDataUserRepository.save(obj);
    }

    @Override
    public void remove(User obj) {
        springDataUserRepository.delete(obj);
    }

    @Override
    public User get(Long id) {
        return springDataUserRepository.findById(id).orElseThrow(ObjetoNaoEncontradoException::new);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return springDataUserRepository.findAll(pageable);
    }

    @Override
    public User findByUsername(String username) {
    return springDataUserRepository.findByEmail(username).orElseThrow(ObjetoNaoEncontradoException::new);
        
    }
    
}
