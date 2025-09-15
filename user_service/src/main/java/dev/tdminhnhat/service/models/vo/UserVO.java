package dev.tdminhnhat.service.models.vo;

import dev.tdminhnhat.service.entities.UserRole;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class UserVO implements Serializable {

    private String description;
    private Date createdAt;
    private Date updatedAt;
    private String firstName;
    private String lastName;
    private Boolean sex;
    private String address;
    private LocalDate birthDate;
    private String phoneNumber;
    private String avatar;
    private String email;
    private String username;
    private Boolean verify;
    private UserRole role;

    public UserVO(String description, Date createdAt, Date updatedAt, String firstName, String lastName, Boolean sex, String address, LocalDate birthDate, String phoneNumber, String avatar, String email, String username, Boolean verify, UserRole role) {
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.address = address;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.email = email;
        this.username = username;
        this.verify = verify;
        this.role = role;
    }
}
