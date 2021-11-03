package sillas.SpringWebWithJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sillas.SpringWebWithJPA.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByName(String name);
}
