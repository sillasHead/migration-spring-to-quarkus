package sillas.SpringWebWithJpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sillas.SpringWebWithJpa.entities.Person;
import sillas.SpringWebWithJpa.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id).get();
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public Person update(Long id, Person person) {
        Person personToUpdate = repository.getOne(id);
        personToUpdate.setName(person.getName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAge(person.getAge());
        return repository.save(personToUpdate);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Person> findByName(String name) {
        return repository.findByName(name);
    }
}
