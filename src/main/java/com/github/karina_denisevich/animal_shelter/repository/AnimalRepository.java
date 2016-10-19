package com.github.karina_denisevich.animal_shelter.repository;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("select a from Animal a where a.user.id = :id")
    List<Animal> getAnimalsByUserId(@Param("id") Long id);
}
