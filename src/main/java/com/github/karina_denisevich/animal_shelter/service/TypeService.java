package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.entity.Type;
import com.github.karina_denisevich.animal_shelter.entity.enums.TypeEnum;

public interface TypeService {

    Type saveType(Type type);

    Type findType(TypeEnum type);
}
