package dev.skyherobrine.services.model.qo;

import dev.skyherobrine.library.dto.PageRequestDto;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public record PlaneQO(

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String planeId,

        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String planeName,

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String countryId,

        @Digits(integer = 10, fraction = 2, message = "This property contains only 10 digits integer and 2 digits fraction")
        BigDecimal startWidthMeter,

        @Digits(integer = 10, fraction = 2, message = "This property contains only 10 digits integer and 2 digits fraction")
        BigDecimal endWidthMeter,

        @Digits(integer = 10, fraction = 2, message = "This property contains only 10 digits integer and 2 digits fraction")
        BigDecimal startHeightMeter,

        @Digits(integer = 10, fraction = 2, message = "This property contains only 10 digits integer and 2 digits fraction")
        BigDecimal endHeightMeter,

        @Positive(message = "This property contains the capacity which's greater than 0")
        Integer startCapacity,

        @Positive(message = "This property contains the capacity which's greater than 0")
        Integer endCapacity,

        Boolean deleteFlag,

        List<String> serviceNames,

        List<String> facilityNames,

        PageRequestDto pageRequest

) implements Serializable {
}
