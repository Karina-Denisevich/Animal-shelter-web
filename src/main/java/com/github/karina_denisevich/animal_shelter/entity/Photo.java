package com.github.karina_denisevich.animal_shelter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photo")
public class Photo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "photo_link")
    private String photo_link;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Photo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photo_link='" + photo_link + '\'' +
                ", animal=" + animal +
                '}';
    }
}
