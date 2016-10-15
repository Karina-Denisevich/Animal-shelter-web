package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.User;

public interface UserService {

    void saveUser(final User user);

    User findUserByLogin(final String login);

    User findUserByEmail(String email);

    void delete(long id);
}
