package com.github.karina_denisevich.animal_shelter.beans.validators;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("request")
public class PhotoValidator {

    private static final int MAX_SIZE = 2097152;

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        if (value != null) {
            FacesMessage message = null;
            Part file = (Part) value;

            if (!("image/jpeg".equals(file.getContentType()) || "image/png".equals(file.getContentType()))) {
                message = new FacesMessage(file.getContentType() + " is not a jpg or png file");
            } else if (file.getSize() > MAX_SIZE) {
                message = new FacesMessage("file too big");
            }
            if (message != null) {
                ctx.addMessage(comp.getClientId(), message);
                throw new ValidatorException(message);
            }
        }
    }
}
