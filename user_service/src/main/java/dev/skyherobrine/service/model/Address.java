package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "addresses")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Address extends AbstractEntityProperty {

    @Column(name = "number", length = 100, nullable = false)
    @NonNull
    private String number;

    @Column(name = "street", length = 100, nullable = false)
    @NonNull
    private String street;

    @Column(name = "state", length = 100, nullable = false)
    @NonNull
    private String state;

    @Column(name = "city", length = 100, nullable = false)
    @NonNull
    private String city;

    @Column(name = "country", length = 100, nullable = false)
    @NonNull
    private String country;

    @Column(name = "zip_code", nullable = false)
    @NonNull
    private Integer zipCode;
}
