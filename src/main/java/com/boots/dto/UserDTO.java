package com.boots.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserDTO {

    private Integer Id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 8, max = 200)
    private String password;
    private String role;
    @Size(min = 12, max = 13, message = "The number should look like this 375335963957")
    private Integer number;


}