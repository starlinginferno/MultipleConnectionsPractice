package com.multipleconnections.trial.repositories;

import com.multipleconnections.trial.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
