package com.github.karina_denisevich.animal_shelter.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getCurrentUserName() {
        User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    public String getCurrentUserRole() {
        User user;
        try {
            user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
        } catch (Exception ex) {
            return "ROLE_ANONYMOUS";
        }
        return user.getAuthorities().iterator().next().toString();
    }
}
