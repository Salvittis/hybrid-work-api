package br.com.fiap.hybridflow.controller;

import br.com.fiap.hybridflow.dto.AuthDTO;
import br.com.fiap.hybridflow.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthDTO.Response> register(@RequestBody @Valid AuthDTO.Register request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO.Response> login(@RequestBody @Valid AuthDTO.Login request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
