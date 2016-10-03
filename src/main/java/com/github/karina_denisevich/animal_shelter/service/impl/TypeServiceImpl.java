package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.enums.TypeEnum;
import com.github.karina_denisevich.animal_shelter.repository.TypeRepository;
import com.github.karina_denisevich.animal_shelter.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional(readOnly = true)
    @Override
    public Type findType(TypeEnum type) {
        return typeRepository.findType(type);
    }
}
