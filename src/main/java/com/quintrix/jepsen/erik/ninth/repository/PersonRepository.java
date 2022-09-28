package com.quintrix.jepsen.erik.ninth.repository;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.quintrix.jepsen.erik.ninth.model.Person;

public interface PersonRepository extends MongoRepository<Person, UUID> {
}
