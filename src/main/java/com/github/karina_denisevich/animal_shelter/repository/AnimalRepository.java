package com.github.karina_denisevich.animal_shelter.repository;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
