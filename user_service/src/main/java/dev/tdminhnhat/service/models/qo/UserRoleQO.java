package dev.tdminhnhat.service.models.qo;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link dev.tdminhnhat.service.entities.UserRole}
 */
public record UserRoleQO(@Size(message = "Maximum length of 'code' is 30 characters", max = 30) String code,
                         @Size(max = 200) String roleName) implements Serializable {
}