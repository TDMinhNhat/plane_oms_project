package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import dev.skyherobrine.service.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "users")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class User extends AbstractEntityProperty {

    @Column(name = "user_id", length = 30, nullable = false, unique = true)
    @NonNull
    private String userId;

    @Column(name = "first_name", length = 100, nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "middile_name", length = 100, nullable = false)
    @NonNull
    private String middleName;

    @Column(name = "last_name", length = 100, nullable = false)
    @NonNull
    private String lastName;

    @Column(name = "sex", nullable = false)
    @NonNull
    private Boolean sex;

    @Column(name = "phone_number", length = 30, nullable = false, unique = true)
    @NonNull
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private Address address;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NonNull
    private String username;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(name = "password", length = 100, nullable = false, unique = true)
    @NonNull
    private String password;

    @Column(name = "avatar_url", length = 300)
    private String avatarUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    @NonNull
    private UserRole roleId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false, columnDefinition = "DEFAULT 1")
    private UserStatus status;

    public User(String description, @NonNull String userId, @NonNull String firstName, @NonNull String middleName, @NonNull String lastName, @NonNull Boolean sex, @NonNull String phoneNumber, Address address, @NonNull String username, @NonNull String email, @NonNull String password, String avatarUrl, @NonNull UserRole roleId) {
        super(description);
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.roleId = roleId;
    }
}
