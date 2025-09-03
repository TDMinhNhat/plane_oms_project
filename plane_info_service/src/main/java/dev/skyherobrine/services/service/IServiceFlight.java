package dev.skyherobrine.services.service;

import dev.skyherobrine.services.model.dto.ServiceDto;
import dev.skyherobrine.services.model.qo.ServiceQO;
import dev.skyherobrine.services.entity.Service;

public interface IServiceFlight extends IManagement<ServiceDto, String, Service, ServiceQO> {
}
