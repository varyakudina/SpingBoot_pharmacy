package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password")
    @Size(min = 8, max = 200)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "number")
    @Size(min = 12, max = 13, message = "The number should look like this 375335963957")
    private Integer number;

    @Column(name = "login")
    private String login;

}