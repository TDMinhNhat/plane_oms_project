package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.math.BigDecimal;

@MappedSuperclass
@Getter @Setter
@RequiredArgsConstructor
public abstract class ReviewEmotion extends AbstractEntityProperty {

    @Column(name = "count", nullable = false, columnDefinition = "DEFAULT 0")
    private BigDecimal count;

    public ReviewEmotion(String description) {
        super(description);
        this.count = BigDecimal.ZERO;
    }
}
