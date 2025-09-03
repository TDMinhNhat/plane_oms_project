package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.entity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FacilityRepository extends ListCrudRepository<Facility, Long>, ListPagingAndSortingRepository<Facility, Long> {

    @Query("""
        SELECT f FROM Facility f
        WHERE f.facilityId IS NOT NULL OR f.facilityId = :facilityId
        AND f.facilityName IS NOT NULL OR f.facilityName = :facilityName
        AND f.deleteFlag IS NOT NULL OR f.deleteFlag = :deleteFlag
        """)
    Page<Facility> getAllFacilities(
            @Param("facilityId") String facilityId,
            @Param("facilityName") String facilityName,
            @Param("deleteFlag") Boolean deleteFlag,
            Pageable pageable,
            Sort sort);

    Optional<Facility> findFacilityByFacilityId(String facilityId);
}
