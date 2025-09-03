package dev.skyherobrine.services.service.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.model.dto.PlaneDto;
import dev.skyherobrine.services.model.qo.PlaneQO;
import dev.skyherobrine.services.entity.Plane;
import dev.skyherobrine.services.entity.PlaneFacility;
import dev.skyherobrine.services.repository.*;
import dev.skyherobrine.services.service.IPlaneService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@org.springframework.stereotype.Service
public class PlaneService implements IPlaneService {

    private final PlaneRepository planeRepository;
    private final ServiceRepository serviceRepository;
    private final FacilityRepository facilityRepository;
    private final PlaneServiceRepository planeServiceRepository;
    private final PlaneFacilityRepository planeFacilityRepository;
    private final CountryRepository countryRepository;

    public PlaneService(PlaneRepository planeRepository, ServiceRepository serviceRepository, FacilityRepository facilityRepository, PlaneServiceRepository planeServiceRepository, PlaneFacilityRepository planeFacilityRepository, CountryRepository countryRepository) {
        this.planeRepository = planeRepository;
        this.serviceRepository = serviceRepository;
        this.facilityRepository = facilityRepository;
        this.planeServiceRepository = planeServiceRepository;
        this.planeFacilityRepository = planeFacilityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Plane createOrUpdate(PlaneDto planeDto) {
        Optional<Plane> planeOptional = planeRepository.findPlaneByPlaneId(planeDto.planeId());
        if(planeOptional.isPresent()) {
            Plane plane = planeOptional.get();
            plane.setPlaneName(planeDto.planeName());
            plane.setCapacity(planeDto.capacity());
            plane.setCountry(countryRepository.findByCountryId(planeDto.countryId()).orElseThrow(() -> new NotFoundException("The countryId = " + planeDto.countryId() + " wasn't found in database.")));
            plane.setWidthMeter(planeDto.widthMeter());
            plane.setHeightMeter(planeDto.heightMeter());
            plane.setCapacity(planeDto.capacity());
            plane.setDescription(planeDto.description());
            return planeRepository.save(plane);
        } else {
            Plane plane = new Plane(
                    planeDto.description(), planeDto.planeId(), planeDto.planeName(), null,
                    countryRepository.findByCountryId(planeDto.countryId()).orElseThrow(() -> new NotFoundException("The countryId = " + planeDto.countryId() + " wasn't found in database."))
                    , planeDto.widthMeter(), planeDto.heightMeter(), planeDto.capacity()
            );
            Plane planeSave = planeRepository.save(plane);
            planeServiceRepository.saveAll(planeDto.serviceId().stream().map(serviceId ->
                    new dev.skyherobrine.services.entity.PlaneService(planeSave, serviceRepository.findServiceByServiceId(serviceId).orElseThrow(() -> new NotFoundException("The serviceId = " + serviceId + " wasn't found in database")))).toList());
            planeFacilityRepository.saveAll(planeDto.facilityId().stream().map(facilityId ->
                    new PlaneFacility(planeSave, facilityRepository.findFacilityByFacilityId(facilityId).orElseThrow(() -> new NotFoundException("The facilityId = " + facilityId + " wasn't found in database.")))).toList());
            return planeSave;
        }
    }

    @Override
    public Plane delete(String s) {
        Plane plane = planeRepository.findPlaneByPlaneId(s).orElseThrow(() -> new NotFoundException("The planeId = " + s + " wasn't found in database"));
        plane.setDeleteFlag(true);
        return planeRepository.save(plane);
    }

    @Override
    public Plane findById(String s) {
        return planeRepository.findPlaneByPlaneId(s).orElseThrow(() -> new NotFoundException("The planeId = " + s + " wasn't found in database"));
    }

    @Override
    public PageResponse<Plane> findAll(PlaneQO filter) {
        return null;
    }
}
