package br.com.fiap.hybridflow.controller;

import br.com.fiap.hybridflow.dto.WorkStationDTO;
import br.com.fiap.hybridflow.model.WorkStation;
import br.com.fiap.hybridflow.service.WorkStationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
@RequiredArgsConstructor
public class WorkStationController {

    private final WorkStationService service;

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<WorkStation> create(@RequestBody @Valid WorkStationDTO.Request request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<WorkStation>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
