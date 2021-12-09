package com.boots.controller;

import com.boots.dto.UserDTO;
import com.boots.exception.ValidationException;
import com.boots.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/users")
@Log
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/saveUsers")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) throws ValidationException {
        log.info("Handling save user: " + userDTO);
        return userService.saveUser(userDTO);
    }

    @GetMapping("/findAllUsers")
    public List<UserDTO> findAllUser() {
        log.info("Handling find all users request");
        return userService.findAllUser();
    }

    @GetMapping("/findUsersByPassword")
    public UserDTO findByPassword(@RequestParam String password) {
        log.info("Handling find by password request: " + password);
        return userService.findByPassword(password);
    }

    @DeleteMapping("/deleteUsers/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        log.info("Handling delete user request: " + userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
