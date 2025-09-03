package dev.skyherobrine.services.controller.impl;

import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.controller.IManagementController;
import dev.skyherobrine.services.model.dto.CountryDto;
import dev.skyherobrine.services.model.qo.CountryQO;
import dev.skyherobrine.services.entity.Country;
import dev.skyherobrine.services.service.impl.CountryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("plane-info/api/v1/country")
public class CountryController implements IManagementController<CountryDto, String, Country, CountryQO> {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Country> createOrUpdate(@Valid @RequestBody CountryDto countryDto) {
        return ResponseEntity.ok(countryService.createOrUpdate(countryDto));
    }

    @DeleteMapping("/{countryId}")
    @Override
    public ResponseEntity<Country> delete(@PathVariable("countryId") String id) {
        return ResponseEntity.ok(countryService.delete(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<PageResponse<Country>> findAll(@Valid @RequestBody CountryQO countryQO) {
        return ResponseEntity.ok(countryService.findAll(countryQO));
    }
}
