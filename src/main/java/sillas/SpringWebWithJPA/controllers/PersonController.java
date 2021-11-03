package sillas.SpringWebWithJpa.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sillas.SpringWebWithJpa.entities.Person;
import sillas.SpringWebWithJpa.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping
    public ResponseEntity<List<Person>> findByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findByNameOrderByAge(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findByNameOrderByAge(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findByIdentifier(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findByIdentifier(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findOfAgeOlderThan(@RequestParam(name = "age") Integer age) {
        return ResponseEntity.ok(service.findOfAgeOlderThan(age));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(service.save(person));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Person> update(@PathVariable(name = "id") Long id, @RequestBody Person person) {
        return ResponseEntity.ok(service.update(id, person));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }
}
