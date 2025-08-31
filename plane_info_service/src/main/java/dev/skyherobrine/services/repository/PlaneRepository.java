package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
