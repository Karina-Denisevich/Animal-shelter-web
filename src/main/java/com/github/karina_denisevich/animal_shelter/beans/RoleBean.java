package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.enums.RoleEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope("request")
public class RoleBean {

    private Map<String, Object> roleMap;

    public Map<String, Object> getRoleMap() {
        roleMap = new LinkedHashMap<>();

        for (RoleEnum roleEnum : RoleEnum.values()) {
            roleMap.put(roleEnum.toString(), roleEnum);
        }
        return roleMap;
    }

    public void setRoleMap(Map<String, Object> roleMap) {
        this.roleMap = roleMap;
    }
}
