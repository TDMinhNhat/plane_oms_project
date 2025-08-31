package dev.skyherobrine.services.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "facilities")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Facility extends AbstractEntityProperty {

    @Column(name = "facility_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String facilityName;

    @Column(name = "facility_description", length = 300)
    private String facilityDescription;

    @Column(name = "facility_icon_url", length = 300)
    private String facilityIconUrl;

    public Facility(@NonNull String facilityName, String facilityDescription, String facilityIconUrl) {
        this.facilityName = facilityName;
        this.facilityDescription = facilityDescription;
        this.facilityIconUrl = facilityIconUrl;
    }
}
