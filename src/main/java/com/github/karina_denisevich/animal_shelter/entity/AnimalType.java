package com.github.karina_denisevich.animal_shelter.entity;

import com.github.karina_denisevich.animal_shelter.entity.enums.AnimalTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "animal_type")
public class AnimalType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "animal_type")
    @Enumerated(EnumType.STRING)
    private AnimalTypeEnum animalType;

    @OneToMany(mappedBy = "animalType", fetch = FetchType.LAZY)
    private Collection<Animal> animals;

    public AnimalType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AnimalTypeEnum getAnimalTypeEnum() {
        return animalType;
    }

    public void setAnimalTypeEnum(AnimalTypeEnum animalTypeEnum) {
        this.animalType = animalTypeEnum;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "id=" + id +
                ", animalType=" + animalType +
                ", animals=" + animals +
                '}';
    }
}
