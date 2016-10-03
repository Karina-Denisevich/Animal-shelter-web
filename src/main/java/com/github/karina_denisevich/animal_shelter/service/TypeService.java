package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.entity.enums.TypeEnum;

public interface TypeService {

    Type saveType(Type type);

    Type findType(TypeEnum type);
}
