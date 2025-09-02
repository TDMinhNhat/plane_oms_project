package dev.skyherobrine.library.models;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageResponse extends PageImpl<Object> {

    public PageResponse(List<Object> content) {
        super(content);
    }

    public PageResponse(List<Object> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
