package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user_roles")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class UserRole extends AbstractEntityProperty {

    @Column(name = "role_code", length = 30, nullable = false, unique = true)
    @NonNull
    private String roleCode;

    @Column(name = "role_name", length = 300, nullable = false, unique = true)
    @NonNull
    private String roleName;
}
