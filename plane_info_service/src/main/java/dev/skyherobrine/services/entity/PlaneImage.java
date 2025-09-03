package dev.skyherobrine.services.entity;


import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plane_images")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class PlaneImage extends AbstractEntityProperty {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id", nullable = false)
    @NonNull
    private Plane plane;

    @Column(name = "image_url", length = 300, nullable = false)
    @NonNull
    private String imageUrl;
}
