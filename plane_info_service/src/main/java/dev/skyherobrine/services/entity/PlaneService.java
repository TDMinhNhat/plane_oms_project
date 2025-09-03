package dev.skyherobrine.services.entity;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plane_services")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class PlaneService extends AbstractEntityProperty {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plane_id", nullable = false)
    @NonNull
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @NonNull
    private Service service;
}
