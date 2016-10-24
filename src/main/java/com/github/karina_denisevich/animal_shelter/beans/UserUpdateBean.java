package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class UserUpdateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    UserService userService;

    @Autowired
    UserInfoBean userInfoBean;

    private User userToUpdate;
    private User oldUser;
    private String password;

    public void updateUser() {
        if (!oldUser.equals(userToUpdate)
                || (!password.isEmpty() && !new BCryptPasswordEncoder().matches(password, oldUser.getPassword()))) {
            if (!password.isEmpty() && !new BCryptPasswordEncoder().matches(password, oldUser.getPassword())) {
                userToUpdate.setPassword(password);
            }
            userService.updateUser(userToUpdate);
            userInfoBean.getUserList().set(userInfoBean.getUserList().indexOf(oldUser), userToUpdate);
        }
    }

    public User getUserToUpdate() {
        return userToUpdate;
    }

    public void setUserToUpdate(User userToUpdate) {
        this.userToUpdate = userToUpdate;
    }

    public User getOldUser() {
        return oldUser;
    }

    public void setOldUser(User oldUser) {
        this.oldUser = oldUser;
        userToUpdate = new User().copyUser(oldUser);
        System.out.println("))))))))))))))))))))))))))");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
