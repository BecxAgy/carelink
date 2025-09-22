package com.ws.carelink.core.application.representation.user;

import com.ws.carelink.core.domain.user.User;

import lombok.Data;

@Data
public class UserRepresentation {
    Long id;
    String email;
    String name;

    
    public static UserRepresentation toRepresentation(User user) {
        UserRepresentation representation = new UserRepresentation();
        representation.setId(user.getId());
        representation.setEmail(user.getEmail());
        representation.setName(user.getName());
        return representation;
    }
}
