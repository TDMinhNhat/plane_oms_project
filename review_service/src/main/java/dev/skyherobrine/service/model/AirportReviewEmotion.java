package dev.skyherobrine.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity @Table(name = "airport_review_emotions")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class AirportReviewEmotion extends ReviewEmotion {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_review_id", nullable = false)
    @NonNull
    private AirportReview airportReview;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emotion_id", nullable = false)
    @NonNull
    private Emotion emotion;

    public AirportReviewEmotion(String description, @NonNull AirportReview airportReview, @NonNull Emotion emotion) {
        super(description);
        this.airportReview = airportReview;
        this.emotion = emotion;
    }
}
