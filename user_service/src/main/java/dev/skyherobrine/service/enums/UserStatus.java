package dev.skyherobrine.service.enums;

public enum UserStatus {
    TEMPORARY_BANNED(0), ACTIVE(1), BANNED(2);

    private final Integer value;

    UserStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
