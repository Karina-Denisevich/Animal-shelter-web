package com.github.karina_denisevich.animal_shelter.beans;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@Scope("session")
public class UserInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private UserService userService;

    @Autowired
    private AnimalOfUserBean animalOfUserBean;

    private List<User> userList;
    private List<User> selectedUsers;
    private User oneUser;

    @PostConstruct
    public void init() {
        userList = userService.getAllUsers();
    }

    public void deleteAll() {
        for (User user : selectedUsers) {
            for (Animal animal : user.getAnimals()) {
                animalOfUserBean.deleteAnimal(animal);
            }
            userList.remove(user);
            userService.delete(user.getId());
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<User> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public User getOneUser() {
        return oneUser;
    }

    public void setOneUser(User oneUser) {
        this.oneUser = oneUser;
    }
}
