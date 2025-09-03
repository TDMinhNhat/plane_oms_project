package dev.skyherobrine.services.dto.filter;

import dev.skyherobrine.library.dto.PageRequestDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record FacilityFilterDto(

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String facilityId,

        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String facilityName,

        Boolean deleteFlag,

        @NotNull(message = "This property can not be null or empty")
        PageRequestDto pageRequest

) implements Serializable {
}
