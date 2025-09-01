package dev.skyherobrine.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "airport_review")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class AirportReview extends Review{

    @Column(name = "airport_id")
    @NonNull
    private String airportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_reivew_parent_id")
    private AirportReview airportReviewParent;

    public AirportReview(String description, @NonNull String customerId, @NonNull String content, String airportId, AirportReview airportReviewParent) {
        super(description, customerId, content);
        this.airportId = airportId;
        this.airportReviewParent = airportReviewParent;
    }
}
