package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.beans.models.UserModelBean;
import com.github.karina_denisevich.animal_shelter.model.entity.Role;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.model.enums.RoleEnum;
import com.github.karina_denisevich.animal_shelter.service.RoleService;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Scope("request")
public class RegistrationBean {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserModelBean userModelBean;

    public RegistrationBean() {
    }

    public void saveUser() throws IOException {
        Role role = roleService.findRole(RoleEnum.ROLE_USER);

        boolean enabled = true;

        User user = new User();
        user.setLogin(userModelBean.getLogin());
        user.setEmail(userModelBean.getEmail());
        user.setPassword(userModelBean.getPassword());
        user.setCity(userModelBean.getCity());
        user.setPhoneNumber(userModelBean.getPhoneNumber());
        user.setRole(role);
        user.setEnabled(enabled);

        //userService.saveUser(user);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserModelBean getUserModelBean() {
        return userModelBean;
    }

    public void setUserModelBean(UserModelBean userModelBean) {
        this.userModelBean = userModelBean;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
