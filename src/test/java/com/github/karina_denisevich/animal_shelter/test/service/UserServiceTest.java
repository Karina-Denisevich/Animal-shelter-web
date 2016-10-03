package com.github.karina_denisevich.animal_shelter.test.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Animal;
import com.github.karina_denisevich.animal_shelter.model.entity.Role;
import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.entity.User;
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

    @Resource
    private AnimalService animalService;

    @Resource
    private TypeService typeService;


    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSave() throws Exception {

    }
}


//    Role role = new Role();
//    role.setRole(RoleEnum.ROLE_ADMIN);
//    roleService.saveRole(role);
//    role=new Role();
//    role.setRole(RoleEnum.ROLE_ANONYMOUS);
//    roleService.saveRole(role);
//    role=new Role();
//    role.setRole(RoleEnum.ROLE_USER);
//    roleService.saveRole(role);

//        Role role = roleService.findRole(RoleEnum.ROLE_ADMIN);
//        User user = new User();
//        user.setEnabled(true);
//        user.setCity("Hrodna");
//        user.setPassword("1111");
//        user.setLogin("Karina");
//        user.setPhoneNumber("+375291111111");
//        user.setEmail("Karina@mail.ru");
//        user.setRole(role);
//        userService.saveUser(user);

//        Type type = new Type();
//        type.setType(TypeEnum.ANY);
//        typeService.saveType(type);

//        Type type = typeService.findType(TypeEnum.CAT);
//        User user = userService.findUserByLogin("Mark");
//
//        Animal animal = new Animal();
//        animal.setName("Tom");
//        animal.setGender(GenderEnum.MALE);
//        animal.setType(type);
//        animal.setInfo("Tom is a kind little cat.");
//        animal.setUser(user);
//        animalService.saveAnimal(animal);