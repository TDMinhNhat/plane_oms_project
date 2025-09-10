package dev.skyherobrine.services.controller.impl;

import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.controller.IManagementController;
import dev.skyherobrine.services.model.dto.ServiceDto;
import dev.skyherobrine.services.model.qo.ServiceQO;
import dev.skyherobrine.services.entity.Service;
import dev.skyherobrine.services.service.IServiceFlightService;
import dev.skyherobrine.services.service.impl.ServiceFlightServiceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plane-info/api/v1/service")
public class ServiceController implements IManagementController<ServiceDto, String, Service, ServiceQO> {

    private final IServiceFlightService serviceFlightService;

    public ServiceController(ServiceFlightServiceService serviceFlightService) {
        this.serviceFlightService = serviceFlightService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Service> createOrUpdate(@Valid @RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(serviceFlightService.createOrUpdate(serviceDto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Service> delete(@PathVariable("id") String s) {
        return ResponseEntity.ok(serviceFlightService.delete(s));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageResponse<Service>> findAll(@Valid @RequestBody ServiceQO serviceQO) {
        return ResponseEntity.ok(serviceFlightService.findAll(serviceQO));
    }
}
