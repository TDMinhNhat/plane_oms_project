package dev.tdminhnhat.service.services.impl;

import dev.skyherobrine.library.exceptions.NotFoundException;
import dev.skyherobrine.library.models.PageResponse;
import dev.tdminhnhat.service.entities.User;
import dev.tdminhnhat.service.models.dto.UserDTO;
import dev.tdminhnhat.service.models.qo.UserQO;
import dev.tdminhnhat.service.models.vo.UserVO;
import dev.tdminhnhat.service.repositories.UserRepository;
import dev.tdminhnhat.service.repositories.UserRoleRepository;
import dev.tdminhnhat.service.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User add(@Valid UserDTO entity) {
        User user = new User();
        BeanUtils.copyProperties(entity, user);
        user.setUserId(generateUserId());
        user.setRole(userRoleRepository.findById(entity.roleId()).orElseThrow(() -> new NotFoundException("The roleId " + entity.roleId() + " wasn't found in database")));
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User update(String userId, @Valid UserDTO entity) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("The userId " + userId + " wasn't found in database"));
        BeanUtils.copyProperties(entity, user, "email", "password");
        return userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User delete(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("The userId " + userId + " wasn't found in database"));
        user.setDeleteFlag(true);
        return userRepository.save(user);
    }

    @Override
    public User findById(String userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("The userId " + userId + " wasn't found in database"));
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public PageResponse<UserVO> findAll(UserQO filter) {
        Page<UserVO> users = userRepository.getAllUsersByFilter(filter, filter.pageRequest().getPageable());
        return new PageResponse<>(users.getContent(), (long) users.getTotalPages(), users.getTotalElements(), (long) users.getNumber(), users.hasNext(), users.hasPrevious());
    }

    private String generateUserId() {
        String userId = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        userId += ThreadLocalRandom.current().nextInt(1000, 9999);
        return userId;
    }
}
