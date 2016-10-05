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

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import java.io.Serializable;

@Component
@Scope("request")
public class RegistrationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    public UserService userService;

    @Autowired
    public RoleService roleService;

    @Autowired
    public UserModelBean userModelBean;

    public RegistrationBean() {
    }

    public void saveUser(){
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

        userService.saveUser(user);
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

    public void validateLogin(ComponentSystemEvent event){
        UIComponent components = event.getComponent();

        // get password
        UIInput uiInputLogin = (UIInput) components.findComponent("login");
        String login = uiInputLogin.getLocalValue() == null ? ""
                : uiInputLogin.getLocalValue().toString();
        String loginId = uiInputLogin.getClientId();

        if (login.isEmpty()) {
            return;
        }

        if(userService.findUserByLogin(login) != null){
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("There is already the person with the same name!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(loginId, msg);
            fc.renderResponse();
        }
    }

    public void validatePassword(ComponentSystemEvent event){
        UIComponent components = event.getComponent();

        // get password
        UIInput uiInputPassword = (UIInput) components.findComponent("password");
        String password = uiInputPassword.getLocalValue() == null ? ""
                : uiInputPassword.getLocalValue().toString();
        String passwordId = uiInputPassword.getClientId();

        // get confirm password
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirm-password");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();

        // Let required="true" do its job.
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }
        FacesContext fc = FacesContext.getCurrentInstance();

        if (!password.equals(confirmPassword)) {
            FacesMessage msg = new FacesMessage("Password must match confirm password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(passwordId, msg);
            fc.renderResponse();
        }
    }
}
