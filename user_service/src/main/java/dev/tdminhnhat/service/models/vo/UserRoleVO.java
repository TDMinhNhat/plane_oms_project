package dev.tdminhnhat.service.models.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class UserRoleVO implements Serializable {
    private final String description;
    private final Boolean deleteFlag;
    private final Date createdAt;
    private final Date updatedAt;
    private final String createdBy;
    private final String updatedBy;
    private final Long version;
    private final String code;
    private final String roleName;
}