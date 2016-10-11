package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.repository.AnimalRepository;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal saveAnimal(final Animal animal) {return animalRepository.save(animal);
    }
}
