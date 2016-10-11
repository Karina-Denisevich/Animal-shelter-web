package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.enums.TypeEnum;

import java.util.List;

public interface TypeService {

    void saveType(final Type type);

    Type findType(final TypeEnum type);

    List<Type> getAll();
}
