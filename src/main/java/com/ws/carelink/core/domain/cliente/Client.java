package com.ws.carelink.core.domain.cliente;

import com.ws.carelink.core.domain.usuario.User;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cl_client")
@Data
public class Client {
    private Long id;
    private String phone;
    private String cpf;
    private String photoUrl;

    @OneToOne(mappedBy = "client")
    private User user;
    
}
