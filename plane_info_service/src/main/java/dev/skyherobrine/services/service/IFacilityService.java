package dev.skyherobrine.services.service;

import dev.skyherobrine.services.model.dto.FacilityDto;
import dev.skyherobrine.services.model.qo.FacilityQO;
import dev.skyherobrine.services.entity.Facility;

public interface IFacilityService extends IManagement<FacilityDto, String, Facility, FacilityQO> {
}
