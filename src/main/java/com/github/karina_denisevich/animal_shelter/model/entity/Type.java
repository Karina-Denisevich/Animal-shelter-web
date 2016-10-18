package com.github.karina_denisevich.animal_shelter.model.entity;

import com.github.karina_denisevich.animal_shelter.model.enums.TypeEnum;

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

    @OneToMany(mappedBy = "type", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<Animal> animals;

    public Type() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum typeEnum) {
        this.type = typeEnum;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type1 = (Type) o;

        if (id != type1.id) return false;
        return type == type1.type;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type=" + type +
                ", animals=" + animals +
                '}';
    }
}
