package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.repository.AnimalRepository;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.getOne(id);
    }

    @Override
    public Animal saveAnimal(final Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Animal> getAnimalsByUserId(Long id) {
        return animalRepository.getAnimalsByUserId(id);
    }
}
