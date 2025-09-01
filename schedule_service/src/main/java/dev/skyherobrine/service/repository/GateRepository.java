package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.Gate;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface GateRepository extends ListCrudRepository<Gate, Long>, ListPagingAndSortingRepository<Gate, Long> {
}
