package dev.skyherobrine.services.service;

import dev.skyherobrine.services.model.dto.CountryDto;
import dev.skyherobrine.services.model.qo.CountryQO;
import dev.skyherobrine.services.entity.Country;

public interface ICountryService extends IManagement<CountryDto, String, Country, CountryQO> {
}
