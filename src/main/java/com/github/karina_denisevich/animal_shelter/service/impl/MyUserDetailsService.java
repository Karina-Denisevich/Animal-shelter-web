package com.github.karina_denisevich.animal_shelter.service.impl;

import com.github.karina_denisevich.animal_shelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.github.karina_denisevich.animal_shelter.entity.User user = userService.findUserByLogin(login);

        Collection<SimpleGrantedAuthority> grantedAuthorities = user.getRoles().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getRole().toString())).collect(Collectors.toCollection(ArrayList::new));

        return new User(user.getLogin(),
                user.getPassword(), grantedAuthorities);
    }
}