package dev.skyherobrine.services.model.dto;

import dev.skyherobrine.services.entity.Facility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record FacilityDto(

        @NotBlank(message = "This property can not be null or empty")
        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String facilityId,

        @NotBlank(message = "This property can not be null or empty")
        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String facilityName,

        @Size(max = 300, message = "Maximum length of this property is 300 characters")
        String description
) implements Serializable {

    public Facility toObject() {
        return new Facility(description, facilityId, facilityName, null);
    }
}
