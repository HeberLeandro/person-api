package com.github.heberleandro.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.heberleandro.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
