package dev.skyherobrine.services.model.dto;

import dev.skyherobrine.services.entity.Service;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record ServiceDto(

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String serviceId,

        @NotBlank(message = "This property can not be null or empty")
        @Size(max = 200, message = "Maximum length of this propery is 200 characters")
        String serviceName,

        @Size(max = 300, message = "Maximum length of this property is 300 characters")
        String description
) implements Serializable {
    public Service toObject() {
        return new Service(description, serviceId, serviceName, null);
    }
}
