package dev.tdminhnhat.service.services;

import dev.tdminhnhat.service.entities.User;
import dev.tdminhnhat.service.models.dto.UserDTO;
import dev.tdminhnhat.service.models.qo.UserQO;

public interface IUserService extends IServiceManagement<UserDTO, String, User, UserQO>{
}
