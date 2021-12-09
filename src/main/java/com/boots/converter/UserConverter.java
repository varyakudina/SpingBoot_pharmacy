package com.boots.converter;

import com.boots.dto.UserDTO;
import com.boots.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromUserDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUser_id(userDTO.getUser_id());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setNumber(userDTO.getNumber());
        return user;
    }

    public UserDTO fromUserToUserDTO(User user) {
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .number(user.getNumber())
                .build();
    }
}