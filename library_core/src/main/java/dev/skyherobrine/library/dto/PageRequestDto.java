package dev.skyherobrine.library.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.domain.Sort;

import java.util.Map;

public record PageRequestDto(

        @PositiveOrZero(message = "The page number must be greater or equal to 0")
        Integer page,

        @Positive(message = "The size number must be greater than 0")
        Integer size,

        Map<String, Sort.Direction> sorts
) {
}
