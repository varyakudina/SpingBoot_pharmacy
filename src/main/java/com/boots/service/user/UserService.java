package com.boots.service.user;

import com.boots.dto.UserDTO;
import com.boots.exception.ValidationException;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO) throws ValidationException;

    void deleteUser(Integer user_id);

    UserDTO findByLogin(String login);

    UserDTO findByPassword(String password);

    void updateUser(UserDTO userDTO);

    List<UserDTO> findAllUser();

}
