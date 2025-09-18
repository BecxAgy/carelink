package com.ws.carelink.infra.out.persistence.jpa.converter;

import com.ws.carelink.core.domain.user.RoleValues;

import jakarta.persistence.AttributeConverter;

public class RoleValuesConverter implements AttributeConverter<RoleValues, String> {

    @Override
    public String convertToDatabaseColumn(RoleValues attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public RoleValues convertToEntityAttribute(String dbData) {
        return dbData != null ? RoleValues.valueOf(dbData) : null;
    }
    
}
