package dev.tdminhnhat.service.entities;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Table(name = "users")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class User extends AbstractEntityProperty {

    @Column(name = "user_id", length = 30, unique = true, nullable = false)
    @NonNull
    private String userId;

    @Column(name = "first_name", length = 50, nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NonNull
    private String lastName;

    @Column(name = "sex", nullable = false) @NonNull
    private Boolean sex;

    @Column(name = "address", length = 400)
    private String address;

    @Column(name = "birth_date", nullable = false) @NonNull
    private LocalDate birthDate;

    @Column(name = "phone_number", length = 30, nullable = false, unique = true) @NonNull
    private String phoneNumber;

    private String avatar;

    @Column(name = "email", length = 200, unique = true, nullable = false) @NonNull
    private String email;

    @Column(name = "username", length = 100, unique = true, nullable = false) @NonNull
    private String username;

    @Column(name = "password", length = 100, nullable = false) @NonNull
    private String password;

    @Column(name = "verify", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE") @NonNull
    private Boolean verify;

    @ManyToOne @JoinColumn(name = "role_id", nullable = false)
    @NonNull
    private UserRole role;
}
