package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.entity.User;

public interface UserService {

    User saveUser(User user);

    User findUserByLogin(String login);
}
