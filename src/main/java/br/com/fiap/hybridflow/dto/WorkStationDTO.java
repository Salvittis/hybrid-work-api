package br.com.fiap.hybridflow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class WorkStationDTO {

    @Data
    public static class Request {
        @NotBlank
        private String code;
        private boolean hasMonitor;
        private boolean isSilentZone;
    }
}
