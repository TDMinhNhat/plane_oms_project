package dev.tdminhnhat.service.repositories;

import dev.tdminhnhat.service.entities.UserRole;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends ListCrudRepository<UserRole, Long> {

}
