package dev.skyherobrine.services.entity;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plane_facilities")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class PlaneFacility extends AbstractEntityProperty {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plane_id", nullable = false)
    @NonNull
    private Plane plane;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facility_id", nullable = false)
    @NonNull
    private Facility facility;
}
