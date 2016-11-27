package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope("request")
public class TypeBean {

    @Autowired
    private TypeService typeService;

    private Map<String, Object> typesMap;

    public TypeBean() {
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public Map<String, Object> getTypesMap() {
        typesMap = new LinkedHashMap<>();

        for (Type type : typeService.getAll()) {
            typesMap.put(type.getType().toString(), type);
        }
        return typesMap;
    }
}
