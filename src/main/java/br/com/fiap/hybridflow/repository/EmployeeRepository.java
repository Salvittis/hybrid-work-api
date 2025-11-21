package br.com.fiap.hybridflow.repository;

import br.com.fiap.hybridflow.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByCorporateEmail(String email);
}
