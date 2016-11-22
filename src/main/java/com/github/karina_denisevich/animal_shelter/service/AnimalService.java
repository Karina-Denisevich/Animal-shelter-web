package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.Type;

import java.util.List;

public interface AnimalService {

    Animal getAnimalById(Long id);

    Animal saveAnimal(final Animal animal);

    void deleteAnimal(Long id);

    List<Animal> getAnimalsByUserId(Long id);

    List<Animal> getAllAnimals();

    List<Animal> getAnimalsByType(Type type);
}
