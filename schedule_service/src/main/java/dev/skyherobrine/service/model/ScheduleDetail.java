package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "schedule_details")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class ScheduleDetail extends AbstractEntityProperty {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id", nullable = false)
    @NonNull
    private Schedule schedule;

    @Column(name = "point_stop", nullable = false)
    @NonNull
    private Integer pointStop;

    @ManyToOne @JoinColumn(name = "airport_id", nullable = false)
    @NonNull
    private Airport airport;

    @Column(name = "estimated_arrival", nullable = false)
    @NonNull
    private Date estimatedArrival;

    @Column(name = "distance_km", nullable = false)
    @NonNull
    private Long distance;
}
