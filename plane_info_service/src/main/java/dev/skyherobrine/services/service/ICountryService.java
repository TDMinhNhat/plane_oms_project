package dev.skyherobrine.services.service;

import dev.skyherobrine.services.dto.CountryDto;
import dev.skyherobrine.services.dto.filter.CountryFilterDto;
import dev.skyherobrine.services.model.Country;

public interface ICountryService extends IManagement<CountryDto, String, Country, CountryFilterDto> {
}
