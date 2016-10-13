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
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

@Component
@Scope("request")
public class AnimalRegistrationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    public UserService userService;

    @Autowired
    public AnimalService animalService;

    @Autowired
    public TypeService typeService;

    @Autowired
    public PhotoService photoService;

    @Autowired
    AnimalModelBean animalModelBean;

    @Autowired
    UserBean userBean;

    @Autowired
    PhotoBean photoBean;

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
        // animalService.saveAnimal(animal);
        System.out.println("++++++++++++++++");

        photoBean.upload();
        if (!(photoBean.getFileName() == null || photoBean.getFileName().isEmpty())) {
            Photo photo = new Photo();
            photo.setAnimal(animal);
            photo.setPhotoLink(photoBean.getFileName());
            // photoService.savePhoto(photo);
        }
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
