package dev.skyherobrine.service.enums;

public enum ScheduleStatus {
    CANCELED(0), WAITING(1), CHECK_IN(2), ONBOARD(3), DEPARTURE(4), DONE(5);

    private final Integer value;

    ScheduleStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
