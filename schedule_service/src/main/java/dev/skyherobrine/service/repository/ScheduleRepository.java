package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
