package com.ws.carelink.infra.in.ws.caregiver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.carelink.application.command.CreateCaregiverCommand;

@RestController
@RequestMapping("/v1/caregiver")
public class CaregiverResource {

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCaregiverCommand command) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

}
