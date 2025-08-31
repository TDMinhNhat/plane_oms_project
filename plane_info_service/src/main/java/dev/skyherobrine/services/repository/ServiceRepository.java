package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.model.Service;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ServiceRepository extends ListCrudRepository<Service, Long>, ListPagingAndSortingRepository<Service, Long> {
}
