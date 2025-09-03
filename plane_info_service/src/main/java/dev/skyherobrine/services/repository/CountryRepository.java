package dev.skyherobrine.services.repository;

import dev.skyherobrine.services.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryRepository extends ListCrudRepository<Country, Long> {
    Optional<Country> findByCountryId(String countryId);

    @Query("""
        SELECT c FROM Country c
        WHERE c.countryId IS NULL OR c.countryId = :countryId
        AND c.countryName IS NULL OR c.countryName = :countryName
        AND c.deleteFlag IS NULL OR c.deleteFlag = :deleteFlag       
    """)
    Page<Country> getAllCountries(
            @Param("countryId") String countryId,
            @Param("countryName") String countryName,
            @Param("deleteFlag") Boolean deleteFlag,
            Pageable pageable,
            Sort sort
    );
}
