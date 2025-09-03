package dev.skyherobrine.services.service;

import dev.skyherobrine.services.dto.FacilityDto;
import dev.skyherobrine.services.dto.filter.FacilityFilterDto;
import dev.skyherobrine.services.model.Facility;

public interface IFacilityService extends IManagement<FacilityDto, String, Facility, FacilityFilterDto> {
}
