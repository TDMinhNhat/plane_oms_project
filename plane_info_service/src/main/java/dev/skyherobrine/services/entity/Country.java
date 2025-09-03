package dev.skyherobrine.services.entity;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "countries")
@Getter @Setter
@Builder
@NoArgsConstructor @RequiredArgsConstructor
public class Country extends AbstractEntityProperty {
    @Column(name = "country_id", length = 10, nullable = false, unique = true)
    @NonNull
    private String countryId;

    @Column(name = "country_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String countryName;

    public Country(String description, @NonNull String countryId, @NonNull String countryName) {
        super(description);
        this.countryId = countryId;
        this.countryName = countryName;
    }
}
