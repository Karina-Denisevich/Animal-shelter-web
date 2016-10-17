package com.github.karina_denisevich.animal_shelter.model.entity;

import com.github.karina_denisevich.animal_shelter.model.enums.GenderEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "animal")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "info")
    private String info;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @OneToMany(mappedBy = "animal", cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
    private Collection<Photo> photos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Animal() {
    }

    public Animal(String name, GenderEnum gender, String info,
                  Type type, Collection<Photo> photos, User user) {
        this.name = name;
        this.gender = gender;
        this.info = info;
        this.type = type;
        this.photos = photos;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type animalType) {
        this.type = animalType;
    }

    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        return gender == animal.gender;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }
}
