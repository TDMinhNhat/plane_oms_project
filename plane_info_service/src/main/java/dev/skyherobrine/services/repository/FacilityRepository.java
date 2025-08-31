package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.model.Facility;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface FacilityRepository extends ListCrudRepository<Facility, Long>, ListPagingAndSortingRepository<Facility, Long> {
}
