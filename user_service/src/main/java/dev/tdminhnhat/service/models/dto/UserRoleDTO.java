package dev.tdminhnhat.service.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record UserRoleDTO(String description,
                          @Size(message = "Maximum length 'code' is 30 characters", max = 30)
                          @NotBlank(message = "The property 'code' can not be null or empty")
                          String code,
                          @Size(max = 200, message = "Maximum length 'roleName' is 200 characters")
                          @NotBlank(message = "The property 'roleName' can not be null or empty")
                          String roleName) implements Serializable {
}