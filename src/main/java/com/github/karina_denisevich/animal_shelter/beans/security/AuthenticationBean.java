package com.github.karina_denisevich.animal_shelter.beans.security;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@ManagedBean(name = "authenticationBean")
public class AuthenticationBean {

    public String doLogin() throws ServletException, IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) externalContext.getRequest())
                .getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest) externalContext.getRequest(),
                (ServletResponse) externalContext.getResponse());
        facesContext.responseComplete();
        return null;
    }

    public String doLogout() throws ServletException, IOException {
        System.out.println("In doLogout()");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/logout");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();
        return null;
    }
}
