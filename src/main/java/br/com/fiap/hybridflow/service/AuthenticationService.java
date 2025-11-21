package br.com.fiap.hybridflow.service;

import br.com.fiap.hybridflow.config.TokenService;
import br.com.fiap.hybridflow.dto.AuthDTO;
import br.com.fiap.hybridflow.model.Employee;
import br.com.fiap.hybridflow.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final EmployeeRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthDTO.Response register(AuthDTO.Register request) {
        var employee = new Employee();
        employee.setFullName(request.getName());
        employee.setCorporateEmail(request.getEmail());
        employee.setPassword(passwordEncoder.encode(request.getPassword()));
        employee.setProfile(request.getProfile());

        repository.save(employee);
        var jwt = tokenService.generateToken(employee);
        return new AuthDTO.Response(jwt);
    }

    public AuthDTO.Response authenticate(AuthDTO.Login request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var employee = repository.findByCorporateEmail(request.getEmail())
                .orElseThrow();
        var jwt = tokenService.generateToken(employee);
        return new AuthDTO.Response(jwt);
    }
}
