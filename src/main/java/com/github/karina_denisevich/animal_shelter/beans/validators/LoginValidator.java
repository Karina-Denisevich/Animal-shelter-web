package com.github.karina_denisevich.animal_shelter.beans.validators;

import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@Component
@Scope("request")
public class LoginValidator {

    @Autowired
    public UserService userService;

    public LoginValidator() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void validateLogin(ComponentSystemEvent event) {
        UIComponent components = event.getComponent();

        // get password

        UIInput uiInputLogin = (UIInput) components.findComponent("login");
        String login = uiInputLogin.getLocalValue() == null ? ""
                : uiInputLogin.getLocalValue().toString();
        String LoginId = uiInputLogin.getClientId();

        if (login.isEmpty()) {
            return;
        }

        if (userService.findUserByEmail(login) != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("There is already the person with the same login!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(LoginId, msg);
            fc.renderResponse();
        }
    }
}
