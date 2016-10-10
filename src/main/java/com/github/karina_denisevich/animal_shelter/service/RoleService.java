package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Role;
import com.github.karina_denisevich.animal_shelter.model.enums.RoleEnum;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    Role findRole(RoleEnum roleEnum);

    List<Role> getAll();

    void delete(long id);
}
