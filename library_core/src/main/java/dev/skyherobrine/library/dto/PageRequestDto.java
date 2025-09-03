package dev.skyherobrine.library.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Map;

public record PageRequestDto(

        @PositiveOrZero(message = "The page number must be greater or equal to 0")
        Integer page,

        @Positive(message = "The size number must be greater than 0")
        Integer size,

        Map<String, Sort.Direction> sorts
) {

    public Pageable getPageable() {
        return Pageable.ofSize(this.size).withPage(this.page);
    }

    public Sort getSort() {
        return Sort.by(sorts.keySet().stream().map(key -> new Sort.Order(sorts.get(key), key)).toList());
    }
}
