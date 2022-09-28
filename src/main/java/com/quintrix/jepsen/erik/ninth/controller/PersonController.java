package com.quintrix.jepsen.erik.ninth.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jepsen.erik.ninth.model.Person;
import com.quintrix.jepsen.erik.ninth.repository.PersonRepository;

@RestController
public class PersonController {
  @Autowired
  private PersonRepository repo;

  @GetMapping("/person")
  public Person[] personGetAll() {
    List<Person> results = repo.findAll();
    return results.toArray(new Person[results.size()]);
  }

  @PostMapping("/person")
  public ResponseEntity<Person> postNewPerson(@RequestBody Person newPerson) {
    repo.insert(newPerson);
    return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
  }

  @DeleteMapping("/person")
  public ResponseEntity<Long> postDeletePerson() {
    long origCount = repo.count();
    repo.deleteAll();
    return new ResponseEntity<>(origCount, HttpStatus.NO_CONTENT);
  }

  @GetMapping("/person/{id}")
  public Person getPersonById(@PathVariable UUID id) {
    return repo.findById(id).orElse(null);
  }

  @DeleteMapping("/person/{id}")
  public ResponseEntity<Long> deletePerson(@PathVariable UUID id) {
    Person doomedPerson = repo.findById(id).orElse(null);
    long origCount = repo.count();
    if (doomedPerson != null)
      repo.delete(doomedPerson);
    return new ResponseEntity<>(origCount - repo.count(), HttpStatus.NO_CONTENT);
  }
}
