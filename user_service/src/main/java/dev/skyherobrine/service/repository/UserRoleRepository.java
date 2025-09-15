package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.UserRole;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRoleRepository extends ListCrudRepository<UserRole, Long> {
}
