package com.github.karina_denisevich.animal_shelter.test.service;

import com.github.karina_denisevich.animal_shelter.entity.Animal;
import com.github.karina_denisevich.animal_shelter.entity.Role;
import com.github.karina_denisevich.animal_shelter.entity.User;
import com.github.karina_denisevich.animal_shelter.entity.enums.GenderEnum;
import com.github.karina_denisevich.animal_shelter.entity.enums.RoleEnum;
import com.github.karina_denisevich.animal_shelter.entity.enums.TypeEnum;
import com.github.karina_denisevich.animal_shelter.service.AnimalService;
import com.github.karina_denisevich.animal_shelter.service.RoleService;
import com.github.karina_denisevich.animal_shelter.service.TypeService;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config.xml")
public class UserServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSave() throws Exception{

        Role role = roleService.findRole(RoleEnum.ROLE_ADMIN);

        User user = new User();
        user.setEnabled(true);
        user.setCity("Gomel");
        user.setPassword("4444");
        user.setLogin("Hanna");
        user.setPhoneNumber("+375294444444");
        user.setEmail("Hanna@gmail.com");
        user.setRole(role);
        userService.saveUser(user);

    }
}
