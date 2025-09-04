package dev.skyherobrine.services.service.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.model.dto.CountryDto;
import dev.skyherobrine.services.model.qo.CountryQO;
import dev.skyherobrine.services.entity.Country;
import dev.skyherobrine.services.repository.CountryRepository;
import dev.skyherobrine.services.service.ICountryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country createOrUpdate(CountryDto countryDto) {
        Country country = countryRepository.findByCountryId(countryDto.countryId()).orElse(countryDto.toObject());
        return countryRepository.save(country);
    }

    @Override
    public Country delete(String countryId) {
        Country country = countryRepository.findByCountryId(countryId).orElseThrow(() -> new NotFoundException("The countryId = " + countryId + " wasn't found in database"));
        country.setDeleteFlag(true);
        return countryRepository.save(country);
    }

    @Override
    public Country findById(String countryId) {
        return countryRepository.findByCountryId(countryId).orElseThrow(() -> new NotFoundException("The countryId = " + countryId + " wasn't found in database"));
    }

    @Override
    public PageResponse<Country> findAll(CountryQO filter) {
        Page<Country> result = countryRepository.getAllCountries(
                filter.countryId(),
                filter.countryName(),
                filter.deleteFlag(),
                filter.startCreatedDate(),
                filter.endCreatedDate(),
                filter.startUpdatedDate(),
                filter.endUpdatedDate(),
                filter.page().getPageable(),
                filter.page().getSort()
        );

        return new PageResponse<>(result.getContent(), (long) result.getTotalPages(), result.getTotalElements(), (long) result.getNumber(), result.hasNext(), result.hasPrevious());
    }
}
