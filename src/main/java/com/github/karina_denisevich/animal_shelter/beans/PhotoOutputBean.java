package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.Photo;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
@SessionScoped
public class PhotoOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    AnimalService animalService;

    private StreamedContent photo;
    private List<Animal> animalList;

    public StreamedContent getPhoto() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println("if");
            return new DefaultStreamedContent();
        } else {
            System.out.println("else");
            Path path = Paths.get(PhotoBean.PATH_TO_PHOTO + "image.jpg");

            String id = context.getExternalContext().getRequestParameterMap().get("animal");
            Animal animal = animalService.getAnimalById(Long.valueOf(id));
            List<Photo> photos = (List<Photo>) animal.getPhotos();

            if (photos.size() > 0) {
                Photo photo = photos.get(0);
                path = Paths.get(PhotoBean.PATH_TO_PHOTO, photo.getPhotoLink().substring(0, 3) + "\\"
                        + photo.getPhotoLink());
            }

            return new DefaultStreamedContent(
                    new ByteArrayInputStream(Files.readAllBytes(path)));
        }
    }

    public void setPhoto(StreamedContent photo) {
        this.photo = photo;
    }

    public List<Animal> getAnimalList() {
        return animalService.getAllAnimal();
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    private Animal animal;
}
