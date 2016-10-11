package com.github.karina_denisevich.animal_shelter.beans.models;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.enums.GenderEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Scope("request")
public class AnimalModelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private GenderEnum gender;

    private String info;

    private Type type;

    public AnimalModelBean() {
    }

    public AnimalModelBean(String name, GenderEnum gender, String info, Type type) {
        this.name = name;
        this.gender = gender;
        this.info = info;
        this.type = type;
    }

    @PostConstruct
    public void init() {
        name = "";
        gender = null;
        info = "";
        type = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
