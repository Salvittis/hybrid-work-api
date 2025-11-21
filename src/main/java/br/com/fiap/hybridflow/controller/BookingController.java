package br.com.fiap.hybridflow.controller;

import br.com.fiap.hybridflow.model.Booking;
import br.com.fiap.hybridflow.service.BookingService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @GetMapping
    @PreAuthorize("hasRole('MANAGER') or hasRole('EMPLOYEE')")
    public ResponseEntity<java.util.List<Booking>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @org.springframework.web.bind.annotation.PostMapping
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<Booking> create(
            @org.springframework.web.bind.annotation.RequestBody @jakarta.validation.Valid br.com.fiap.hybridflow.dto.BookingDTO.CreateRequest request,
            @org.springframework.security.core.annotation.AuthenticationPrincipal br.com.fiap.hybridflow.model.Employee employee) {
        return ResponseEntity.ok(service.create(request, employee));
    }
}
