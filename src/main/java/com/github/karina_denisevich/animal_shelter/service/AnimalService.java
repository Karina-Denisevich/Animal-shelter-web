package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;

import java.util.List;

public interface AnimalService {

    Animal getAnimalById(Long id);
    Animal saveAnimal(final Animal animal);
    List<Animal> getAllAnimal();
}
