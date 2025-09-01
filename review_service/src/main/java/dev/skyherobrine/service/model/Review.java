package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public abstract class Review extends AbstractEntityProperty {

    @Column(name = "customer_id", length = 30, nullable = false)
    @NonNull
    private String customerId;

    @Column(name = "content", length = 300, nullable = false)
    @NonNull
    private String content;

    public Review(String description, @NonNull String customerId, @NonNull String content) {
        super(description);
        this.customerId = customerId;
        this.content = content;
    }
}
