package com.ws.carelink.core.domain.user;

import com.ws.carelink.shared.utils.enumeration.ValueLabelEnum;

public enum Role implements ValueLabelEnum<Role> {
    ADMIN("Administrador"),
    CLIENT("Cliente"),
    CAREGIVER("Cuidador"),
    USER("Usuário");

    private String label;
    

    private Role(String label) {
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