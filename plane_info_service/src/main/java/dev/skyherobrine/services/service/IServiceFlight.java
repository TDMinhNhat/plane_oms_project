package dev.skyherobrine.services.service;

import dev.skyherobrine.services.dto.ServiceDto;
import dev.skyherobrine.services.dto.filter.ServiceFilterDto;
import dev.skyherobrine.services.model.Service;

public interface IServiceFlight extends IManagement<ServiceDto, String, Service, ServiceFilterDto> {
}
