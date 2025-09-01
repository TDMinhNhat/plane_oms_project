package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.Address;
import org.springframework.data.repository.ListCrudRepository;

public interface AddressRepository extends ListCrudRepository<Address, Long> {
}
