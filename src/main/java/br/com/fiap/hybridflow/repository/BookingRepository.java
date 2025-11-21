package br.com.fiap.hybridflow.repository;

import br.com.fiap.hybridflow.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
