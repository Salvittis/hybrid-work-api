package br.com.fiap.hybridflow.repository;

import br.com.fiap.hybridflow.model.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {
}
