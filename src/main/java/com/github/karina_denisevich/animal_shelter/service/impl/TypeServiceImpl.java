package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.enums.TypeEnum;
import com.github.karina_denisevich.animal_shelter.repository.TypeRepository;
import com.github.karina_denisevich.animal_shelter.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    @Transactional
    public void saveType(final Type type) {
        typeRepository.save(type);
    }

    @Override
    public Type findType(final TypeEnum type) {
        return typeRepository.findType(type);
    }

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
