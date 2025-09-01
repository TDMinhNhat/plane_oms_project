package dev.skyherobrine.service.repository;

import dev.skyherobrine.service.model.Terminal;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface TerminalRepository extends ListCrudRepository<Terminal, Long>, ListPagingAndSortingRepository<Terminal, Long> {
}
