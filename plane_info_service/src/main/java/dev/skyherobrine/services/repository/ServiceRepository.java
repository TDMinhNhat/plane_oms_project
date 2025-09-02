package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ServiceRepository extends ListCrudRepository<Service, Long>, ListPagingAndSortingRepository<Service, Long> {
    Optional<Service> findServiceByServiceId(String serviceId);

    @Query("""
            SELECT s FROM Service s
            WHERE s.serviceId IS NOT NULL AND s.serviceId = :serviceId
            AND s.serviceName IS NOT NULL AND s.serviceName = :serviceName
            AND s.deleteFlag IS NOT NULL AND s.deleteFlag = :deleteFlag
        """)
    Page<Service> getAllServices(
            @Param("serviceId") String serviceId,
            @Param("serviceName") String serviceName,
            @Param("deleteFlag") Boolean deleteFlag,
            Pageable pageable,
            Sort sort);
}
