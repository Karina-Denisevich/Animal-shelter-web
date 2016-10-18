package com.github.karina_denisevich.animal_shelter.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "photo_link")
    private String photoLink;

    @ManyToOne
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

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photo_link) {
        this.photoLink = photo_link;
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
                ", photoLink='" + photoLink +
                '}';
    }
}
