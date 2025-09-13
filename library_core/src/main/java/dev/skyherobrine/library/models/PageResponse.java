package dev.skyherobrine.library.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageResponse<S> {
    private List<S> data;
    private Long totalPages;
    private Long totalElements;
    private Long currentPage;
    private Boolean hasNext;
    private Boolean hasPrevious;
}
