package dev.skyherobrine.services.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "planes")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Plane extends AbstractEntityProperty {

    @Column(name = "plane_id", length = 50, nullable = false, unique = true)
    @NonNull
    private String planeId;

    @Column(name = "plane_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String planeName;

    @Column(name = "plane_logo_url", length = 300)
    private String planeLogoUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    @NonNull
    private Country country;

    @Column(name = "width_meter", nullable = false)
    @NonNull
    private BigDecimal widthMeter;

    @Column(name = "height_meter", nullable = false)
    @NonNull
    private BigDecimal heightMeter;

    @Column(name = "capacity", nullable = false)
    @NonNull
    private Integer capacity;

    @Column(name = "description", length = 300)
    private String description;

    public Plane(@NonNull String planeId, @NonNull String planeName, String planeLogoUrl, @NonNull Country country, @NonNull BigDecimal widthMeter, @NonNull BigDecimal heightMeter, @NonNull Integer capacity, String description) {
        this.planeId = planeId;
        this.planeName = planeName;
        this.planeLogoUrl = planeLogoUrl;
        this.country = country;
        this.widthMeter = widthMeter;
        this.heightMeter = heightMeter;
        this.capacity = capacity;
        this.description = description;
    }
}
