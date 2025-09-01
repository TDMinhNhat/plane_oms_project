package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.Emotion;
import org.springframework.data.repository.ListCrudRepository;

public interface EmotionRepository extends ListCrudRepository<Emotion, Long> {
}
