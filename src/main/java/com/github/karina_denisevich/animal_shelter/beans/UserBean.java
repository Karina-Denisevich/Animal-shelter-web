package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.service.UserService;
import com.github.karina_denisevich.animal_shelter.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.convert.DateTimeConverter;
import java.io.Serializable;

@Component
@Scope("session")
public class UserBean implements Serializable {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getFirstUserMail() {
        return userService.findUserByLogin("Karina").getEmail();
    }
}
