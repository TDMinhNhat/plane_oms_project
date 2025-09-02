package dev.skyherobrine.services.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "services")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Service extends AbstractEntityProperty {
    @Column(name = "service_name", length = 200, nullable = false, unique = true)
    @NonNull
    private String serviceName;

    @Column(name = "service_icon_url", length = 300)
    private String serviceIconUrl;

    public Service(String description, @NonNull String serviceName, String serviceIconUrl) {
        super(description);
        this.serviceName = serviceName;
        this.serviceIconUrl = serviceIconUrl;
    }
}
