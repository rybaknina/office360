package com.senla.office360.service;

import com.senla.office360.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Person getOne(int id);
    Optional<Person> findById(int id);
    void delete(Person person);
    Person save(Person person);
}
