package com.github.karina_denisevich.animal_shelter.test.service;

import com.github.karina_denisevich.animal_shelter.entity.Role;
import com.github.karina_denisevich.animal_shelter.entity.User;
import com.github.karina_denisevich.animal_shelter.entity.enums.RoleEnum;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config.xml")
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
        role.setRole(RoleEnum.ROLE_ADMIN);
        User user = new User();
        user.setLogin("karina");
        user.setPassword("1111");
        user.setEnabled(true);
        user.setEmail("karina_41997@mail.ru");
        Collection<Role> collection = new ArrayList();
        collection.add(role);
        user.setRoles(collection);
        userService.saveUser(user);
    }
}
