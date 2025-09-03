package dev.skyherobrine.services.service.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.library.models.PageResponse;
import dev.skyherobrine.services.model.dto.FacilityDto;
import dev.skyherobrine.services.model.qo.FacilityQO;
import dev.skyherobrine.services.entity.Facility;
import dev.skyherobrine.services.repository.FacilityRepository;
import dev.skyherobrine.services.service.IFacilityService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility createOrUpdate(FacilityDto facilityDto) {
        Facility result = facilityRepository.findFacilityByFacilityId(facilityDto.facilityId()).orElse(facilityDto.toObject());
        result.setFacilityName(facilityDto.facilityName());
        return facilityRepository.save(result);
    }

    @Override
    public Facility delete(String s) {
        Facility result = facilityRepository.findFacilityByFacilityId(s).orElseThrow(() -> new NotFoundException("The facilityId = " + s + " wasn't found in database."));
        result.setDeleteFlag(false);
        return facilityRepository.save(result);
    }

    @Override
    public Facility findById(String s) {
        return facilityRepository.findFacilityByFacilityId(s).orElseThrow(() -> new NotFoundException("The facilityId = " + s + " wasn't found in database."));
    }

    @Override
    public PageResponse<Facility> findAll(FacilityQO filter) {
        Page<Facility> result = facilityRepository.getAllFacilities(
                filter.facilityId(),
                filter.facilityName(),
                filter.deleteFlag(),
                filter.pageRequest().getPageable(),
                filter.pageRequest().getSort()
        );
        return new PageResponse<Facility>(
                result.getContent(),
                (long) result.getTotalPages(),
                result.getTotalElements(),
                (long) result.getNumber(),
                result.hasNext(),
                result.hasPrevious()
        );
    }
}
