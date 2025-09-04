package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface CountryRepository extends ListCrudRepository<Country, Long> {
    Optional<Country> findByCountryId(String countryId);

    @Query("""
        SELECT c FROM Country c
        WHERE (:countryId IS NULL OR c.countryId = :countryId)
        AND (:countryName IS NULL OR c.countryName = :countryName)
        AND (:deleteFlag IS NULL OR c.deleteFlag = :deleteFlag)
        AND (:startCreatedAt IS NULL OR :endCreatedAt IS NULL) OR (c.createdAt >= :startCreatedAt AND c.createdAt <= :endCreatedAt)
        AND (:startUpdatedAt IS NULL OR :endUpdatedAt IS NULL) OR (c.updatedAt >= :updatedCreatedAt AND c.updatedAt <= :endUpdatedAt)       
    """)
    Page<Country> getAllCountries(
            @Param("countryId") String countryId,
            @Param("countryName") String countryName,
            @Param("deleteFlag") Boolean deleteFlag,
            @Param("startCreatedAt") Date startCreatedAt,
            @Param("endCreatedAt") Date endCreatedAt,
            @Param("startUpdatedAt") Date startUpdatedAt,
            @Param("endUpdatedAt") Date endUpdatedAt,
            Pageable pageable,
            Sort sort
    );
}
