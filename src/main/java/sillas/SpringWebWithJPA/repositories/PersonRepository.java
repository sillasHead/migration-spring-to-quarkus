package sillas.SpringWebWithJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sillas.SpringWebWithJpa.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByName(String name);
}
