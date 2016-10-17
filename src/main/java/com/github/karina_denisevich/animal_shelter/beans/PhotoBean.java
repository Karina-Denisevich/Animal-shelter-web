package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.Photo;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sun.misc.IOUtils;
import sun.plugin.javascript.navig.Image;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Component
@Scope("request")
public class PhotoBean {

    private Part file;
    private String fileContent;
    private User user;
    private String fileName;

    @Autowired
    UserService userService;

    @Autowired
    UserBean userBean;

    @PostConstruct
    public void init() {
        file = null;
    }

    public void upload() {
        user = userService.findUserByLogin(userBean.getCurrentUserName());
        if (file != null) {
            String prefix = getFolderName();
            try {
                fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
                InputStream input = file.getInputStream();

                File f = File.createTempFile(prefix, ".jpg", getTargetDirectory());
                Files.copy(input, f.toPath(), StandardCopyOption.REPLACE_EXISTING);

                fileName = f.getName();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File getTargetDirectory() {
        String parent = "D:\\Users\\Karina\\Desktop\\AnimalShelter\\photos\\";
        File dir = new File(parent + getFolderName());

        if (!dir.exists()) {
            try {
                Files.createDirectory(Paths.get(parent + getFolderName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dir;
    }

    private String getFolderName() {
        return user.getLogin().substring(0, 3);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
