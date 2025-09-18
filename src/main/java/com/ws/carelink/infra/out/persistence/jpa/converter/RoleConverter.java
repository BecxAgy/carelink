package com.ws.carelink.infra.out.persistence.jpa.converter;

import com.ws.carelink.core.domain.user.Role;

import jakarta.persistence.AttributeConverter;

public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return dbData != null ? Role.valueOf(dbData) : null;
    }
    
}
