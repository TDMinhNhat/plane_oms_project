package dev.skyherobrine.services.controller.impl;

import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.controller.IManagementController;
import dev.skyherobrine.services.dto.ServiceDto;
import dev.skyherobrine.services.dto.filter.ServiceFilterDto;
import dev.skyherobrine.services.model.Service;
import dev.skyherobrine.services.service.impl.ServiceFlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plane-info/api/v1/service")
public class ServiceController implements IManagementController<ServiceDto, String, Service, ServiceFilterDto> {

    private final ServiceFlightService serviceFlightService;

    public ServiceController(ServiceFlightService serviceFlightService) {
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
    public ResponseEntity<PageResponse<Service>> findAll(@Valid @RequestBody ServiceFilterDto serviceFilterDto) {
        return ResponseEntity.ok(serviceFlightService.findAll(serviceFilterDto));
    }
}
