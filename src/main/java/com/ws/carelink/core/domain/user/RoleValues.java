package com.ws.carelink.core.domain.user;

import com.ws.carelink.shared.utils.enumeration.ValueLabelEnum;

public enum RoleValues implements ValueLabelEnum<RoleValues> {
    ADMIN("Administrador"),
    USER("Usuário");

    private String label;
    

    private RoleValues(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getValue() {
        return name();
    }
}