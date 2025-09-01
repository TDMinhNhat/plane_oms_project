package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "gates")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Gate extends AbstractEntityProperty {

    @Column(name = "gate_code", length = 30, nullable = false) @NonNull
    private String gateCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "terminal_id", nullable = false)
    @NonNull
    private Terminal terminal;
}
