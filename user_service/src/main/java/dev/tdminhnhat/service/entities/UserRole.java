package dev.tdminhnhat.service.entities;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity @Table(name = "user_roles")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class UserRole extends AbstractEntityProperty {

    @Column(name = "code", length = 30, unique = true, nullable = false)
    @NonNull
    private String code;

    @Column(name = "role_name", length = 200, unique = true, nullable = false)
    @NonNull
    private String roleName;

    public UserRole(String description, @NonNull String code, @NonNull String roleName) {
        super(description);
        this.code = code;
        this.roleName = roleName;
    }
}
