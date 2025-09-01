package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import dev.skyherobrine.service.enums.ScheduleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @Table(name = "schedules")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Schedule extends AbstractEntityProperty {

    @Column(name = "plane_id", length = 30, nullable = false)
    @NonNull
    private String planeId;

    @Column(name = "check_in_date", nullable = false)
    @NonNull
    private Date checkInDate;

    @Column(name = "onboard_date", nullable = false)
    @NonNull
    private Date onboardDate;

    @Column(name = "departure_date", nullable = false)
    @NonNull
    private Date departureDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gate_id", nullable = false)
    @NonNull
    private Gate gate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false, columnDefinition = "DEFAULT 1")
    private ScheduleStatus status;
}
