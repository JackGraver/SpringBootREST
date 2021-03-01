package com.example.demo.service;

import com.example.demo.models.Person;
import com.example.demo.repository.PersonRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRespository personRespository;

    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public List<Person> getAllPersons() {
        return personRespository.findAll();
    }

    public Person getPersonById(int id) {
        return personRespository.findById(id).orElse(null);
    }

    public Person addPerson(Person person) {
        return personRespository.save(person);
    }

    public Person updatePerson(Person person) {
        Person personUpdated = personRespository.findById(person.getId()).orElse(null);

        if(personUpdated != null) {
            personUpdated.setFirstname(person.getFirstname());
            personUpdated.setLastname(person.getLastname());
            personUpdated.setEmail(person.getEmail());
            return personRespository.save(personUpdated);
        }
        return personUpdated;
    }

    public void deletePerson(int id) {
        personRespository.deleteById(id);
    }

}
