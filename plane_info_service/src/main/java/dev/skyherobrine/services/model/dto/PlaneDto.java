package dev.skyherobrine.services.model.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public record PlaneDto(

        @NotBlank(message = "This property can not be blank or empty")
        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String planeId,

        @NotBlank(message = "This property can not be blank or empty")
        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String planeName,

        @NotBlank(message = "This property can not be blank or empty")
        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String countryId,

        @NotNull(message = "This property can not be null or empty")
        @Digits(integer = 10, fraction = 2, message = "This property only contains maximum 10 digits integer and 2 digits for fraction")
        BigDecimal widthMeter,

        @NotNull(message = "This property can not be null or empty")
        @Digits(integer = 10, fraction = 2, message = "This property only contains maximum 20 digis integer and 2 digits for fraction")
        BigDecimal heightMeter,

        @NotNull(message = "This property can not be null or empty")
        @Positive(message = "This property only contains the number greater than 0")
        Integer capacity,

        @Size(max = 300, message = "Maximum length of this property is 300 characters")
        String description,

        @NotNull(message = "This property can not be null or empty")
        List<String> serviceId,

        @NotNull(message = "This property can not be null or empty")
        List<String> facilityId

) implements Serializable {
}
