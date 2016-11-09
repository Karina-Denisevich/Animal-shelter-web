package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.repository.UserRepository;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void saveUser(final User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findUserByLogin(final String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}
