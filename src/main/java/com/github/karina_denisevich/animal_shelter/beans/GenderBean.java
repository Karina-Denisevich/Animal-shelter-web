package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.enums.GenderEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope("request")
public class GenderBean {

    private Map<String, Object> genderMap;

    public GenderBean() {
    }

    public Map<String, Object> getGenderMap() {
        genderMap = new LinkedHashMap<>();

        for (GenderEnum genderEnum : GenderEnum.values()) {
            genderMap.put(genderEnum.toString(), genderEnum);
        }
        return genderMap;
    }

    public void setGenderMap(Map<String, Object> genderMap) {
        this.genderMap = genderMap;
    }
}
