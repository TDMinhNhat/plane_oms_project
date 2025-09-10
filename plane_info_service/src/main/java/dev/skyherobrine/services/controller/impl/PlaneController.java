package dev.skyherobrine.services.controller.impl;

import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.controller.IManagementController;
import dev.skyherobrine.services.entity.Plane;
import dev.skyherobrine.services.model.dto.PlaneDto;
import dev.skyherobrine.services.model.qo.PlaneQO;
import dev.skyherobrine.services.service.IPlaneService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plane-info/api/v1/plane")
public class PlaneController implements IManagementController<PlaneDto, String, Plane, PlaneQO> {

    private IPlaneService planeService;

    public PlaneController(IPlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Plane> createOrUpdate(@Valid @RequestBody PlaneDto planeDto) {
        return ResponseEntity.ok(planeService.createOrUpdate(planeDto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Plane> delete(@PathVariable("id") String s) {
        return ResponseEntity.ok(planeService.delete(s));
    }

    @PostMapping
    @Override
    public ResponseEntity<PageResponse<Plane>> findAll(@Valid @RequestBody PlaneQO planeQO) {
        return ResponseEntity.ok(planeService.findAll(planeQO));
    }
}
