package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.entity.Role;

import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.github.karina_denisevich.animal_shelter.entity.User user = userService.findUserByLogin(login);

        Collection<SimpleGrantedAuthority> grantedAuthorities = user.getRoles().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getRole().toString())).collect(Collectors.toCollection(ArrayList::new));

        return new User(user.getLogin(), user.getPassword(), user.isEnabled(),
                true, true, true, grantedAuthorities);
    }
}
