package dev.skyherobrine.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse<S> {
    private List<S> data;
    private Integer totalPages;
    private Integer totalElements;
    private Boolean hasNext;
    private Boolean hasPrevious;
}
