package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "terminals")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Terminal extends AbstractEntityProperty {

    @Column(name = "terminal_code", length = 30, nullable = false)
    @NonNull
    private String terminalCode;

    @Column(name = "terminal_name", length = 200, nullable = false)
    @NonNull
    private String terminalName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_id", nullable = false)
    @NonNull
    private Airport airport;
}
