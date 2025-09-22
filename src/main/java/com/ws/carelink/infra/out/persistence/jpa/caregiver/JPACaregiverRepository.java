package com.ws.carelink.infra.out.persistence.jpa.caregiver;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ws.carelink.core.domain.caregiver.Caregiver;
import com.ws.carelink.core.repository.caregiver.CaregiverRepository;
import com.ws.carelink.infra.out.persistence.jpa.caregiver.springdata.SpringDataCaregiverRepository;
import com.ws.carelink.shared.exception.ObjetoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JPACaregiverRepository implements CaregiverRepository {
    
    private final SpringDataCaregiverRepository springDataCaregiverRepository;

    @Override
    public void add(Caregiver obj) {
        springDataCaregiverRepository.save(obj);
    }

    @Override
    public void remove(Caregiver obj) {
        springDataCaregiverRepository.delete(obj);
    }

    @Override
    public Caregiver get(Long id) {
        return springDataCaregiverRepository.findById(id).orElseThrow(ObjetoNaoEncontradoException::new);
    }

    @Override
    public Page<Caregiver> findAll(Pageable pageable) {
        return springDataCaregiverRepository.findAll(pageable);
    }

    
}
