package dev.skyherobrine.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "plane_reviews")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class PlaneReview extends Review{

    @Column(name = "plane_id", length = 30, nullable = false)
    @NonNull
    public String planeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_review_parent_id")
    private PlaneReview planeReviewParent;

    public PlaneReview(String description, @NonNull String customerId, @NonNull String content, @NonNull String planeId, PlaneReview planeReviewParent) {
        super(description, customerId, content);
        this.planeId = planeId;
        this.planeReviewParent = planeReviewParent;
    }
}
