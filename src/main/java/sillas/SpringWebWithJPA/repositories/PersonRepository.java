package sillas.SpringWebWithJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sillas.SpringWebWithJpa.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByName(String name);

    public List<Person> findByNameOrderByAge(String name);

    @Query("from Person where id = :id")
    public Person findByIdentifier(@Param("id") Long id);
    
    @Query("select p from Person p where p.age > ?1")
    public List<Person> findOfAgeOlderThan(Integer age);
}
