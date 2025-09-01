package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.Airport;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface AirportRepository extends ListCrudRepository<Airport, Long>, ListPagingAndSortingRepository<Airport, Long> {
}
