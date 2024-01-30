package org.htwberlin.de.immo_mile_one.controller;

import org.htwberlin.de.immo_mile_one.model.Person;
import org.htwberlin.de.immo_mile_one.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping("/api/persons")
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @PostMapping("/api/person")
    public Person addPerson(@RequestBody Person person) {
        return personService.savePeople(person);
    }

    @GetMapping("/api/login")
    public Person authentification(@RequestParam String email, @RequestParam String password) {
        return personService.loginPerson(email, password);
    }

}
