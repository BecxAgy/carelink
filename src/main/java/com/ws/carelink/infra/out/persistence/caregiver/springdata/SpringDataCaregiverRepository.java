package com.ws.carelink.infra.out.persistence.caregiver.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.carelink.core.domain.caregiver.Caregiver;

@Repository
public interface SpringDataCaregiverRepository extends JpaRepository<Caregiver, Long> {

}
