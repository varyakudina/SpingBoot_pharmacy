package com.boots.config.custome;

import com.boots.converter.UserConverter;
import com.boots.dto.UserDTO;
import com.boots.entity.User;
import com.boots.service.user.*;
import com.boots.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userDTO);
    }
}