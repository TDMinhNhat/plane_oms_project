package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "tickets")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Ticket extends AbstractEntityProperty {

    @Column(name = "ticket_id", length = 30, nullable = false, unique = true)
    @NonNull
    private String ticketId;

    @Column(name = "seat_number", length = 30, nullable = false)
    @NonNull
    private String seatNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price", nullable = false)
    @NonNull
    private Price price;

}
