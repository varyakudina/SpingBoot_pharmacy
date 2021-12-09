package com.boots.repository;

import com.boots.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLoginAndPassword(String login);

    User findByPassword(String password);

    User findByLogin(String login);
}