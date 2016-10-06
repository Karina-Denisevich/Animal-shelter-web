package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.beans.models.AnimalModelBean;
import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.model.enums.GenderEnum;
import com.github.karina_denisevich.animal_shelter.model.enums.TypeEnum;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import com.github.karina_denisevich.animal_shelter.service.TypeService;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
    AnimalModelBean animalModelBean;

    @Autowired
    UserBean userBean;

    public AnimalRegistrationBean() {
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

    public void saveAnimal(){

       // User user = userService.findUserByLogin(userBean.getCurrentUser());
        Type type = typeService.findType(animalModelBean.getType().getType());
       // GenderEnum genderEnum = GenderEnum.valueOf(animalModelBean.getGender());

        Animal animal = new Animal();
//        animal.setName(animalModelBean.getName());
//        animal.setInfo(animalModelBean.getInfo());
        animal.setType(type);
//        animal.setGender(genderEnum);
//        animal.setUser(user);

       // animalService.saveAnimal(animal);
    }
}
