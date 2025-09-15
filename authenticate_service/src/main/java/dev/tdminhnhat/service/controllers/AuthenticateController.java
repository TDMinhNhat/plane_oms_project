package dev.tdminhnhat.service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate/api/v1/authenticate")
public class AuthenticateController {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public AuthenticateController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register() {
        return null;
    }
}
