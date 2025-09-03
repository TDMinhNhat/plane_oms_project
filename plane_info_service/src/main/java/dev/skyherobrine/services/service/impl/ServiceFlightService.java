package dev.skyherobrine.services.service.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.model.dto.ServiceDto;
import dev.skyherobrine.services.model.qo.ServiceQO;
import dev.skyherobrine.services.entity.Service;
import dev.skyherobrine.services.repository.ServiceRepository;
import dev.skyherobrine.services.service.IServiceFlight;
import org.springframework.data.domain.Page;

@org.springframework.stereotype.Service
public class ServiceFlightService implements IServiceFlight {
    
    private final ServiceRepository serviceRepository;

    public ServiceFlightService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Service createOrUpdate(ServiceDto serviceDto) {
        Service service = serviceRepository.findServiceByServiceId(serviceDto.serviceId()).orElse(serviceDto.toObject());
        service.setServiceName(serviceDto.serviceName());
        return serviceRepository.save(service);
    }

    @Override
    public Service delete(String s) {
        Service result = serviceRepository.findServiceByServiceId(s).orElseThrow(() -> new NotFoundException("The serviceId = " + s + " wasn't found in database"));
        result.setDeleteFlag(false);
        return result;
    }

    @Override
    public Service findById(String s) {
        return serviceRepository.findServiceByServiceId(s).orElseThrow(() -> new NotFoundException("The serviceId " + s + " wasn't found in database"));
    }

    @Override
    public PageResponse<Service> findAll(ServiceQO filter) {
        Page<Service> result = serviceRepository.getAllServices(
                filter.serviceId(),
                filter.serviceName(),
                filter.deleteFlag(),
                filter.pageRequest().getPageable(),
                filter.pageRequest().getSort()
        );
        return new PageResponse<Service>(
                result.getContent(),
                (long) result.getTotalPages(),
                result.getTotalElements(),
                (long) result.getNumber(),
                result.hasNext(),
                result.hasPrevious()
        );
    }
}
