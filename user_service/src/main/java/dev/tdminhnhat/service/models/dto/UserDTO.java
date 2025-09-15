package dev.tdminhnhat.service.models.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

public record UserDTO(
        @Size(message = "Maximum length of 'firstName' is 50 characters", max = 50)
        @NotBlank(message = "The property 'firstName' can not be null or empty")
        String firstName,

        @Size(message = "Maximum length of 'lastName' is 50 characters", max = 50)
        @NotBlank(message = "The property 'lastName' can not be null or empty")
        String lastName,

        @NotNull(message = "The property 'sex' can not be null or empty")
        Boolean sex,

        @Size(max = 400, message = "Maximum length of 'address' is 400 characters")
        String address,

        @NotNull(message = "The property 'birthDate' can not be null or empty")
        @PastOrPresent(message = "'birthDate' value only exist with past or present date")
        LocalDate birthDate,

        @Size(message = "Maximum length of 'phoneNumber' can not be null or empty", max = 30)
        @NotBlank(message = "The property 'phoneNumber' can not be null or empty")
        String phoneNumber,

        @Size(message = "Maximum length of 'email' is 200 characters", max = 200)
        @NotBlank(message = "The property 'email' can not be null or empty")
        String email,

        @Size(message = "Maximum length of 'username' is 50 characters", max = 100)
        @NotBlank(message = "The property 'username' can not be null or empty")
        String username,

        @Size(message = "Maximum length 'password' is 100 characters", max = 100)
        @NotBlank(message = "The property 'password' can not be null or empty")
        String password,

        @NotNull(message = "The property 'roleId' can not be null or empty")
        @Positive(message = "The 'roleId' value just be valid with positive number")
        Long roleId
) implements Serializable {

}