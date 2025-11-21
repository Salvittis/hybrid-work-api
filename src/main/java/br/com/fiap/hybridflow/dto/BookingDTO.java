package br.com.fiap.hybridflow.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

public class BookingDTO {

    @Data
    public static class CreateRequest {
        @NotNull
        private Long stationId;

        @NotNull
        @FutureOrPresent
        private LocalDate date;
    }
}
