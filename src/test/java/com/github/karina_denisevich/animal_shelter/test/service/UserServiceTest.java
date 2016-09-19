package com.github.karina_denisevich.animal_shelter.test.service;

import com.github.karina_denisevich.animal_shelter.entity.Role;
import com.github.karina_denisevich.animal_shelter.entity.Type;
import com.github.karina_denisevich.animal_shelter.entity.User;
import com.github.karina_denisevich.animal_shelter.entity.enums.RoleEnum;
import com.github.karina_denisevich.animal_shelter.entity.enums.TypeEnum;
import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;

//@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring-config.xml")
//@WebAppConfiguration
public class UserServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveBank() throws Exception{
        Role role = new Role();
        Role role1 = new Role();
        role.setRole(RoleEnum.ROLE_ADMIN);
        role1.setRole(RoleEnum.ROLE_USER);
        User user = new User();
        user.setLogin("Karina");
        user.setPassword("1111");
        user.setEmail("karina_41997@mail.ru");
        Collection<Role> collection = new ArrayList();
        collection.add(role);
        collection.add(role1);
        user.setRoles(collection);
        userService.saveUser(user);
    }
}
