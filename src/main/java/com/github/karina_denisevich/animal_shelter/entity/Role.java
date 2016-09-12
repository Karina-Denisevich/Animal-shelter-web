package com.github.karina_denisevich.animal_shelter.entity;

import com.github.karina_denisevich.animal_shelter.entity.enums.RoleEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role=" + role +
                ", users=" + users +
                '}';
    }
}
