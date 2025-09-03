package dev.skyherobrine.services.service;

import dev.skyherobrine.services.model.dto.PlaneDto;
import dev.skyherobrine.services.model.qo.PlaneQO;
import dev.skyherobrine.services.entity.Plane;

public interface IPlaneService extends IManagement<PlaneDto, String, Plane, PlaneQO>{
}
