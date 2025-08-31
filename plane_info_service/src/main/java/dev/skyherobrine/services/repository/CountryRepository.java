package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country, Long> {
}
