package dev.skyherobrine.services.dto.filter;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record CountryFilterDto(

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String countryId,

        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String countryName,

        Boolean deleteFlag

) implements Serializable {

}
