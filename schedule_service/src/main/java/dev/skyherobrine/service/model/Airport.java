package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "airports")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Airport extends AbstractEntityProperty {

    @Column(name = "airport_id", length = 30, nullable = false, unique = true)
    @NonNull
    private String airportId;

    @Column(name = "airport_name", length = 200, nullable = false)
    @NonNull
    private String airportName;

    @Column(name = "airport_state", length = 200, nullable = false)
    @NonNull
    private String airportState;

    @Column(name = "airport_country", length = 200, nullable = false)
    @NonNull
    private String airportCountry;
}
