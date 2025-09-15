package dev.tdminhnhat.service.services.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.library.models.PageResponse;
import dev.tdminhnhat.service.entities.UserRole;
import dev.tdminhnhat.service.models.dto.UserRoleDTO;
import dev.tdminhnhat.service.models.qo.UserQO;
import dev.tdminhnhat.service.repositories.UserRoleRepository;
import dev.tdminhnhat.service.services.IUserRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserRoleImpl implements IUserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRole add(@Valid UserRoleDTO entity) {
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(entity, userRole, "id");
        return userRoleRepository.save(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRole update(Long id, @Valid UserRoleDTO entity) {
        UserRole userRole = userRoleRepository.findById(id).orElseThrow(() -> new NotFoundException("The roleId " + id + " wasn't found in database"));
        BeanUtils.copyProperties(entity, userRole, "id");
        return userRoleRepository.save(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserRole delete(Long id) {
        UserRole userRole = userRoleRepository.findById(id).orElseThrow(() -> new NotFoundException("The roleId " + id + " wasn't found in database"));
        userRole.setDeleteFlag(true);
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole findById(Long id) {
        return userRoleRepository.findById(id).orElseThrow(() -> new NotFoundException("The roleId " + id + " wasn't found in database"));
    }

    @Override
    public Collection<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public PageResponse<?> findAll(UserQO filter) {
        return null;
    }
}
