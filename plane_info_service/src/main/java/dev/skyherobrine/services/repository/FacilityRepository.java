package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.entity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface FacilityRepository extends ListCrudRepository<Facility, Long>, ListPagingAndSortingRepository<Facility, Long> {

    @Query("""
        SELECT f FROM Facility f
        WHERE (:facilityId IS NULL OR f.facilityId = :facilityId)
        AND (:facilityName IS NULL OR f.facilityName = :facilityName)
        AND (:deleteFlag IS NULL OR f.deleteFlag = :deleteFlag)
        AND (:startCreatedAt IS NULL OR :endCreatedAt IS NULL) OR (f.createdAt >= :startCreatedAt AND f.createdAt <= :endCreatedAt)
        AND (:startUpdatedAt IS NULL OR :endUpdatedAt IS NULL) OR (f.updatedAt >= :startUpdatedAt AND f.updatedAt <= :endUpdatedAt) 
        """)
    Page<Facility> getAllFacilities(
            @Param("facilityId") String facilityId,
            @Param("facilityName") String facilityName,
            @Param("deleteFlag") Boolean deleteFlag,
            @Param("startCreatedAt") Date startCreatedAt,
            @Param("endCreatedAt") Date endCreatedAt,
            @Param("startUpdatedAt") Date startUpdatedAt,
            @Param("endUpdatedAt") Date endUpdatedAt,
            Pageable pageable,
            Sort sort);

    Optional<Facility> findFacilityByFacilityId(String facilityId);
}
