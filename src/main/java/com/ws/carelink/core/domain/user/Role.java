package com.ws.carelink.core.domain.user;

import com.ws.carelink.infra.out.persistence.jpa.converter.RoleValuesConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "cl_role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Convert(converter = RoleValuesConverter.class)
    private RoleValues value;

}
