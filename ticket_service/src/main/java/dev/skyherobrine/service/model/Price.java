package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity @Table(name = "schedule_prices")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Price extends AbstractEntityProperty {

    @Column(name = "schedule_id", length = 30, nullable = false)
    @NonNull
    private String scheduleId;

    @Column(name = "price", nullable = false)
    @NonNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
