package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@Scope("session")
public class AnimalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    AnimalService animalService;

    private List<Animal> model;

//    public List<Animal> getAll(){
//        return animalService.getAllAnimal();
//    }

    @PostConstruct
    public void init() {
        model=animalService.getAllAnimal();
    }

    public List<Animal> getModel() {
        return model;
    }

    public void setModel(List<Animal> model) {
        this.model = model;
    }
}
