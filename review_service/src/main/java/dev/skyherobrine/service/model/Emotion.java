package dev.skyherobrine.service.model;

import dev.skyherobrine.library.models.AbstractEntityProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity @Table(name = "emotions")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Emotion extends AbstractEntityProperty {

    @Column(name = "emotion_id", length = 30, nullable = false, unique = true)
    @NonNull
    private String emotionId;

    @Column(name = "emotion_name", length = 300, nullable = false, unique = true)
    @NonNull
    private String emotionName;

    @Column(name = "emotion_url", length = 300, nullable = false)
    @NonNull
    private String emotionUrl;

}
