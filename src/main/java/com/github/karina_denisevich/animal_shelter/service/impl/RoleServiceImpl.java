package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.model.entity.Role;
import com.github.karina_denisevich.animal_shelter.model.enums.RoleEnum;
import com.github.karina_denisevich.animal_shelter.repository.RoleRepository;
import com.github.karina_denisevich.animal_shelter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void saveRole(final Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    public Role findRole(final RoleEnum roleEnum) {
        return roleRepository.findRole(roleEnum);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(long id) {
        roleRepository.delete(id);
    }
}
