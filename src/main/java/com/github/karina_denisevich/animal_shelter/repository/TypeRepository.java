package com.github.karina_denisevich.animal_shelter.repository;

import com.github.karina_denisevich.animal_shelter.model.entity.Type;
import com.github.karina_denisevich.animal_shelter.model.enums.TypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query("select t from Type t where t.type = :type")
    Type findType(@Param("type")TypeEnum type);
}
