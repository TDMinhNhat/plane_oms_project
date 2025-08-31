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

    @Column(name = "service_description", length = 300, nullable = false)
    private String serviceDescription;

    @Column(name = "service_icon_url", length = 300, nullable = false)
    private String serviceIconUrl;

    public Service(@NonNull String serviceName, String serviceDescription, String serviceIconUrl) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.serviceIconUrl = serviceIconUrl;
    }
}
