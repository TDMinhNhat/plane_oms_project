package dev.skyherobrine.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "plane_review_emotions")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class PlaneReviewEmotion extends ReviewEmotion{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_review_id", nullable = false)
    @NonNull
    private PlaneReview planeReview;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emotion_id", nullable = false)
    @NonNull
    private Emotion emotion;

    public PlaneReviewEmotion(String description, @NonNull PlaneReview planeReview, @NonNull Emotion emotion) {
        super(description);
        this.planeReview = planeReview;
        this.emotion = emotion;
    }
}
