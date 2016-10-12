package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

@Component
@Scope("request")
public class PhotoBean implements Serializable {

    private static final long serialVersionUID = 1L;

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
        user = userService.findUserByLogin(userBean.getCurrentUserName());
    }

    public void upload() {
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
        File dir = new File("D:\\Users\\Karina\\Desktop\\AnimalShelter\\photos\\" + getFolderName());

        if (!dir.exists()) {
            try {
                Files.createDirectory(Paths.get("D:\\Users\\Karina\\Desktop\\AnimalShelter\\photos\\" + getFolderName()));
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
