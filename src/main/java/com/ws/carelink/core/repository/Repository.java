package com.ws.carelink.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Repository <E, I>{
    public void add(E obj);

    public void remove(E obj);

    public E get(I id);

    public Page<E> findAll(Pageable pageable);
}