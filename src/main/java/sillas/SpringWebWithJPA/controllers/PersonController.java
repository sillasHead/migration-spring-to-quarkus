package sillas.SpringWebWithJPA.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sillas.SpringWebWithJPA.entities.Person;
import sillas.SpringWebWithJPA.services.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService service;
    
    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> findByName(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(service.save(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable(name = "id") Long id, Person person) {
        return ResponseEntity.ok(service.update(id, person));
    }
}
