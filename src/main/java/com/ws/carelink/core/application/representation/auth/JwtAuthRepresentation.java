package com.ws.carelink.core.application.representation.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtAuthRepresentation {
    
    private String token;
    private String refreshToken;

 
}
