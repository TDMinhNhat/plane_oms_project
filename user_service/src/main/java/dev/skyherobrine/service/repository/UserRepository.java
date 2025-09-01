package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
