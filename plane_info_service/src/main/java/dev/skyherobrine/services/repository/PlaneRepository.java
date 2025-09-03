package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.entity.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
    Optional<Plane> findPlaneByPlaneId(String planeId);

    @Query("""
                SELECT p FROM Plane p 
                    INNER JOIN PlaneService ps ON p.planeId = ps.plane.planeId 
                    INNER JOIN PlaneFacility pf ON p.planeId = pf.plane.planeId
                WHERE (:planeId IS NOT NULL OR :planeId = p.planeId)
                AND (:planeName IS NOT NULL OR :planeName = p.planeName)
                AND (:countryId IS NOT NULL OR :countryId = p.country.countryId)
                AND ((:startWidthMeter IS NOT NULL OR :endWidthMeter IS NOT NULL) OR (p.widthMeter >= :startWidthMeter AND p.widthMeter <= :endWidthMeter))
                AND ((:startHeightMeter IS NOT NULL OR :endHeightMeter IS NOT NULL) OR (p.heightMeter >= :startHeightMeter AND p.heightMeter <= :endHeightMeter))
                AND ((:startCapacity IS NOT NULL OR :endCapacity IS NOT NULL) OR (p.capacity >= :startCapacity AND p.capacity <= :endCapacity))          
                AND (:deleteFlag IS NOT NULL OR :deleteFlag = p.deleteFlag)
                AND (:services IS NOT NULL OR ps.service.serviceName IN :services)
                AND (:facilities IS NOT NULL OR pf.facility.facilityName IN :facilities)
            """)
    Page<Plane> getAllPlanes(
            @Param("planeId") String planeId,
            @Param("planeName") String planeName,
            @Param("countryId") String countryId,
            @Param("startWidthMeter") BigDecimal startWidthMeter,
            @Param("endWidthMeter") BigDecimal endWidthMeter,
            @Param("startHeightMeter") BigDecimal startHeightMeter,
            @Param("endHeightMeter") BigDecimal endHeightMeter,
            @Param("startCapacity") Integer startCapacity,
            @Param("endCapacity") Integer endCapacity,
            @Param("deleteFlag") Boolean deleteFlag,
            @Param("services") List<String> services,
            @Param("facilities") List<String> facilities,
            Pageable pageable, Sort sort);
}
