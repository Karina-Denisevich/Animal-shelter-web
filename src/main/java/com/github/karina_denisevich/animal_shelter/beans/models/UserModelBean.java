package com.github.karina_denisevich.animal_shelter.beans.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Scope("request")
public class UserModelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;

    private String email;

    private String password;

    private String city;

    private String phoneNumber;

    @PostConstruct
    public void init() {
        login = "";
        email = "";
        password = "";
        city = "";
        phoneNumber = "";
    }

    public UserModelBean() {
    }

    public UserModelBean(String login, String email, String password, String city, String phoneNumber) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
