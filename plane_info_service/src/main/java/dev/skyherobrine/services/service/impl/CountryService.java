package dev.skyherobrine.services.service.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.services.dto.CountryDto;
import dev.skyherobrine.services.dto.filter.CountryFilterDto;
import dev.skyherobrine.services.model.Country;
import dev.skyherobrine.services.repository.CountryRepository;
import dev.skyherobrine.services.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

    private final CountryRepository countryRepository;

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
    public Collection<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Collection<Country> findAll(Integer page, Integer size, Map<String, Sort.Direction> sorts, CountryFilterDto filter) {
        List<Sort.Order> orders = new ArrayList<>();
        sorts.forEach((property, direction) -> {
            orders.add(new Sort.Order(direction, property));
        });
        return countryRepository.getAllCountries(
                filter.countryId(),
                filter.countryName(),
                filter.deleteFlag(),
                Pageable.ofSize(size).withPage(page),
                Sort.by(orders)
        ).getContent();
    }
}
