package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity @Table(name = "discounts")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Discount extends AbstractEntityProperty {

    @Column(name = "discount_id", length = 30, nullable = false, unique = true)
    @NonNull
    private String discountId;

    @Column(name = "discount_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String discountName;

    @Column(name = "value", nullable = false)
    @NonNull
    private Float value;

    @Column(name = "start_discount_date", nullable = false)
    @NonNull
    private Date startDiscountDate;

    @Column(name = "end_discount_date", nullable = false)
    @NonNull
    private Date endDiscountDate;
}
