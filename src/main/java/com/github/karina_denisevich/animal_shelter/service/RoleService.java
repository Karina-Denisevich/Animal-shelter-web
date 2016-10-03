package com.github.karina_denisevich.animal_shelter.service;

import com.github.karina_denisevich.animal_shelter.model.entity.Role;
import com.github.karina_denisevich.animal_shelter.model.enums.RoleEnum;

public interface RoleService {

    Role saveRole(Role role);

    Role findRole(RoleEnum roleEnum);

    void delete(long id);
}
