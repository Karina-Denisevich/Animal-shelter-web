package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    public String getCurrentUserName(){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username

        return name;
    }
}
