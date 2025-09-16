package com.ws.carelink.infra.in.ws.cuidador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.carelink.core.domain.cuidador.Cuidador;

@RestController
@RequestMapping("/v1/cuidadores")
public class CuidadorResource {

    @PostMapping
    public ResponseEntity<Void> criarCuidador(@RequestBody Cuidador cuidador) {
        

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

}
