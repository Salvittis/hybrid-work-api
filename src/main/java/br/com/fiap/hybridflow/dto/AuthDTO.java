package br.com.fiap.hybridflow.dto;

import br.com.fiap.hybridflow.model.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class AuthDTO {

    @Data
    public static class Login {
        @NotBlank
        @Email
        private String email;
        @NotBlank
        private String password;
    }

    @Data
    public static class Register {
        @NotBlank
        private String name;
        @NotBlank
        @Email
        private String email;
        @NotBlank
        private String password;
        @NotNull
        private Profile profile;
    }

    @Data
    public static class Response {
        private String token;

        public Response(String token) {
            this.token = token;
        }
    }
}
