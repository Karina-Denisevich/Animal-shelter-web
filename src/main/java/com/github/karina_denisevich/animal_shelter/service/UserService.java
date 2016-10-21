package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(final User user);

    User findUserByLogin(final String login);

    User findUserByEmail(String email);

    List<User> getAllUsers();

    void updateUser(final User user);

    void delete(long id);
}
