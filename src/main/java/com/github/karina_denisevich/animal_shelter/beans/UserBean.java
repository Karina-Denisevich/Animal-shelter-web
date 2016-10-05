package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class UserBean implements Serializable {

    private final UserService userService;

    @Autowired
    public UserBean(UserService userService) {
        this.userService = userService;
    }

    public String getFirstUserMail() {
        return userService.findUserByLogin("Karina").getEmail();
    }
}
