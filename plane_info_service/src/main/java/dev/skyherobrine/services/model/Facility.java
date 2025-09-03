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

    @Column(name = "facility_id", length = 30, nullable = false, unique = true)
    @NonNull
    private String facilityId;

    @Column(name = "facility_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String facilityName;

    @Column(name = "facility_icon_url", length = 300)
    private String facilityIconUrl;

    public Facility(String description, @NonNull String facilityId, @NonNull String facilityName, String facilityIconUrl) {
        super(description);
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityIconUrl = facilityIconUrl;
    }
}
