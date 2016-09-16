package com.github.karina_denisevich.animal_shelter.entity;

import com.github.karina_denisevich.animal_shelter.entity.enums.TypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "type")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @OneToMany(mappedBy = "type")
    private Collection<Animal> animals;

    public Type() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeEnum getTypeEnum() {
        return type;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.type = typeEnum;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", animalType=" + type +
                ", animals=" + animals +
                '}';
    }
}
