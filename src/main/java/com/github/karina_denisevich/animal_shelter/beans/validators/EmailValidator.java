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
public class EmailValidator {

    @Autowired
    public UserService userService;

    public EmailValidator() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void validateEmail(ComponentSystemEvent event) {
        UIComponent components = event.getComponent();

        // get password

        UIInput uiInputEmail = (UIInput) components.findComponent("email");
        String email = uiInputEmail.getLocalValue() == null ? ""
                : uiInputEmail.getLocalValue().toString();
        String emailId = uiInputEmail.getClientId();

        if (email.isEmpty()) {
            return;
        }

        if (userService.findUserByEmail(email) != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage("There is already the person with the same email!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(emailId, msg);
            fc.renderResponse();
        }
    }
}
