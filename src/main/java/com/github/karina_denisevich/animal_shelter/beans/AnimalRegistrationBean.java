package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.beans.models.AnimalModelBean;
import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.Photo;
import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import com.github.karina_denisevich.animal_shelter.service.PhotoService;
import com.github.karina_denisevich.animal_shelter.service.TypeService;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Scope("request")
public class AnimalRegistrationBean {

    @Autowired
    AnimalBean animalBean;

    @Autowired
    public UserService userService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private AnimalModelBean animalModelBean;

    @Autowired
    private UserBean userBean;

    @Autowired
    private PhotoBean photoBean;

    public AnimalRegistrationBean() {
    }

    public void saveAnimal() throws IOException {
        User user = userService.findUserByLogin(userBean.getCurrentUserName());
        Type type = typeService.findType(animalModelBean.getType().getType());

        Animal animal = new Animal();
        animal.setName(animalModelBean.getName());
        animal.setInfo(animalModelBean.getInfo());
        animal.setGender(animalModelBean.getGender());
        animal.setType(type);
        animal.setUser(user);
        animalService.saveAnimal(animal);

        photoBean.upload();
        if (!(photoBean.getFileName() == null || photoBean.getFileName().isEmpty())) {
            Photo photo = new Photo();
            photo.setAnimal(animal);
            photo.setPhotoLink(photoBean.getFileName());
            photoService.savePhoto(photo);
        }
        animalBean.setModel(animalService.getAllAnimals());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public void setAnimalModelBean(AnimalModelBean animalModelBean) {
        this.animalModelBean = animalModelBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
