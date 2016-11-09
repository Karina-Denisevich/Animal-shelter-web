package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.repository.AnimalRepository;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.getOne(id);
    }

    @Override
    @Transactional
    public Animal saveAnimal(final Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    @Transactional
    public void deleteAnimal(Long id) {
        animalRepository.delete(id);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getAnimalsByUserId(Long id) {
        return animalRepository.getAnimalsByUserId(id);
    }
}
