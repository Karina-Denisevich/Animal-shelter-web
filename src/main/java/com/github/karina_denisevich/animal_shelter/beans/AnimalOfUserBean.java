package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.model.enums.RoleEnum;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Component
@Scope("session")
public class AnimalOfUserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Animal> animalsOfUser;
    private List<Animal> animalsOfAdmin;
    private List<Animal> selectedAnimals;

    @Autowired
    AnimalService animalService;

    @Autowired
    PhotoBean photoBean;

    @Autowired
    UserBean userBean;

    @Autowired
    UserService userService;

    @PostConstruct
    public void init() {
        User user = userService.findUserByLogin(userBean.getCurrentUserName());
        animalsOfUser = animalService.getAnimalsByUserId(user.getId());
        animalsOfAdmin = animalService.getAllAnimals();
    }

    public void deleteAll() {
        selectedAnimals.forEach(this::deleteAnimal);
    }

    public void deleteAnimal(Animal animal) {
        animal.getPhotos().stream().filter(photo -> !Objects.equals(photo.getPhotoLink(), "image.jpg")).forEach(photo -> {

            photoBean.deletePhotoFromFileSystem(photo.getPhotoLink());
        });
        animalService.deleteAnimal(animal.getId());
        if (Objects.equals(userBean.getCurrentUserRole(), RoleEnum.ROLE_USER.toString())) {
            animalsOfUser.remove(animal);
        } else {
            animalsOfAdmin.remove(animal);
        }
    }

    public List<Animal> getAnimalsOfAdmin() {
        return animalsOfAdmin;
    }

    public void setAnimalsOfAdmin(List<Animal> animalsOfAdmin) {
        this.animalsOfAdmin = animalsOfAdmin;
    }

    public List<Animal> getAnimalsOfUser() {
        return animalsOfUser;
    }

    public void setAnimalsOfUser(List<Animal> animalsOfUser) {
        this.animalsOfUser = animalsOfUser;
    }

    public List<Animal> getSelectedAnimals() {
        return selectedAnimals;
    }

    public void setSelectedAnimals(List<Animal> selectedAnimals) {
        this.selectedAnimals = selectedAnimals;
    }

    public AnimalService getAnimalService() {
        return animalService;
    }

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
