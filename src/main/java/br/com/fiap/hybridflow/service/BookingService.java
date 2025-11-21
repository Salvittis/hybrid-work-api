package br.com.fiap.hybridflow.service;

import br.com.fiap.hybridflow.model.Booking;
import br.com.fiap.hybridflow.repository.BookingRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final br.com.fiap.hybridflow.repository.WorkStationRepository stationRepository;

    public java.util.List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking create(br.com.fiap.hybridflow.dto.BookingDTO.CreateRequest request,
            br.com.fiap.hybridflow.model.Employee employee) {
        var station = stationRepository.findById(request.getStationId())
                .orElseThrow(() -> new RuntimeException("WorkStation not found"));

        // Check if station is already booked for that date
        // (Simplification: assuming no double booking check for now, or adding simple
        // one)

        var booking = new Booking();
        booking.setEmployee(employee);
        booking.setStation(station);
        booking.setDate(request.getDate());
        booking.setCheckedIn(false);

        return bookingRepository.save(booking);
    }
}
