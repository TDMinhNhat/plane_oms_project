package dev.skyherobrine.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse<S> {
    private List<S> data;
    private Long totalPages;
    private Long totalElements;
    private Long currentPage;
    private Long hasNext;
    private Long hasPrevious;
}
