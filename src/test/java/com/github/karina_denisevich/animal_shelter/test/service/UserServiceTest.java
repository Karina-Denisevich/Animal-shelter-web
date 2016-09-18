package com.github.karina_denisevich.animal_shelter.test.service;

import com.github.karina_denisevich.animal_shelter.entity.Type;
import com.github.karina_denisevich.animal_shelter.entity.User;
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
        User user = new User();
        user.setEmail("karina_41997@mail.ru");
       // userService.addUser(user);
    }
}
