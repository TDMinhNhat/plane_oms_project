package dev.skyherobrine.services.dto;

import dev.skyherobrine.services.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.io.Serializable;

public record CountryDto(

        @NotBlank(message = "This property can not be null or empty")
        @Size(max = 30, message = "Maximum length this property is 30 characters")
        String countryId,

        @NotBlank(message = "This property can not be null or empty")
        @Size(max = 200, message = "Maximum length this property is 200 characters")
        String countryName,

        @Size(max = 300, message = "Maximum length this property is 300 characters")
        String description

) implements Serializable {

    public Country toObject() {
        return new Country(countryId, countryName, description);
    }
}
