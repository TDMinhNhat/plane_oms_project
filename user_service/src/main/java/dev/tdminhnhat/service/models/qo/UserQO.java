package dev.tdminhnhat.service.models.qo;

import dev.skyherobrine.library.dto.PageRequestDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public record UserQO(@Size(message = "Maximum length 'userId' is 30 characters", max = 30) String userId,
                     @Size(message = "Maximum length 'firstName' is 50 characters", max = 50) String firstName,
                     @Size(message = "Maximum length 'lastName' is 50 characters", max = 50) String lastName,
                     Boolean sex, LocalDate birthDate,
                     @Size(message = "Maximum length 'phoneNumber' is 30 characters", max = 30) String phoneNumber,
                     @Size(message = "Maximum length 'email' is 200 characters", max = 200) String email,
                     @Size(message = "Maximum length 'username' is 50 characters", max = 50) String username,
                     Boolean verify, String roleName,
                     @NotNull(message = "The property 'pageRequest' can not be null or empty")
                     PageRequestDto pageRequest
) implements Serializable {
}