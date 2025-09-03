package dev.skyherobrine.services.controller.impl;

import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.controller.IManagementController;
import dev.skyherobrine.services.dto.FacilityDto;
import dev.skyherobrine.services.dto.filter.FacilityFilterDto;
import dev.skyherobrine.services.model.Facility;
import dev.skyherobrine.services.service.impl.FacilityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plane-info/api/v1/facility")
public class FacilityController implements IManagementController<FacilityDto, String, Facility, FacilityFilterDto> {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Facility> createOrUpdate(@Valid @RequestBody FacilityDto facilityDto) {
        return ResponseEntity.ok(facilityService.createOrUpdate(facilityDto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Facility> delete(@PathVariable("id") String s) {
        return ResponseEntity.ok(facilityService.delete(s));
    }

    @PostMapping("/get-list")
    @Override
    public ResponseEntity<PageResponse<Facility>> findAll(@Valid @RequestBody FacilityFilterDto facilityFilterDto) {
        return ResponseEntity.ok(facilityService.findAll(facilityFilterDto));
    }
}
