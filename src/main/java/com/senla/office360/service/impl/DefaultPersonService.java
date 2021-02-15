package com.senla.office360.service.impl;

import com.senla.office360.entity.Person;
import com.senla.office360.repository.PersonRepository;
import com.senla.office360.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultPersonService implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public DefaultPersonService() {
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getOne(int id) {
        return personRepository.getOne(id);
    }

    @Override
    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
