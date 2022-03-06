package com.simbirsoft.kvashninkirill.repository;

import com.simbirsoft.kvashninkirill.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
