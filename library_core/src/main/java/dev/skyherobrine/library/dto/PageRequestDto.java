package dev.skyherobrine.library.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.Map;

@Data
@AllArgsConstructor
public class PageRequestDto {

    @PositiveOrZero(message = "The page number must be greater than or equal to 0")
    private Integer page;

    @Positive(message = "The size number must be greater than 0")
    private Integer size;

    private Map<String, Sort.Direction> sort;
}
