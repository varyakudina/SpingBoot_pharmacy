package com.boots.controller.security;


import com.boots.config.jwt.JwtProvider;
import com.boots.entity.User;
import com.boots.dto.UserDTO;
import com.boots.exception.ValidationException;
import com.boots.service.user.*;
import com.boots.converter.UserConverter;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Log
@RestController
public class
AuthController {

    @Autowired
    private  UserConverter userConverter;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody  @Valid RegistrationRequest registrationRequest) throws ValidationException {
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        return userService.saveUser(userConverter.fromUserToUserDTO(user));
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserDTO userDTO = userService.findByPassword(request.getPassword());
        String token = jwtProvider.generateToken(userDTO.getPassword());
        return new AuthResponse(token);
    }
}
