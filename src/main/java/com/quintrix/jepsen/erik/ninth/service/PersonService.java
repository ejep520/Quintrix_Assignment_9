package com.quintrix.jepsen.erik.ninth.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jepsen.erik.ninth.model.Person;
import com.quintrix.jepsen.erik.ninth.repository.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repo;

  public Person findPersonById(UUID id) {
    return repo.findById(id).orElse(null);
  }
}
