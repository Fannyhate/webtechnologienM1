package org.htwberlin.de.immo_mile_one.service;

import org.htwberlin.de.immo_mile_one.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void getPeople() {

        Person person = new Person();
        person.setEmail("tester123@gmail.com");
        person.setFirstName("max Ma");
        person.setIsRenter(true);
        person.setPassword("HashPassword");


        var returnPerson = personService.savePeople(person);

        assertEquals(true, personService.getPeople().size()>0);

        personService.deletePerson(returnPerson.getId());


    }

    @Test
    void getPersonById() {

        Person person = new Person();
        person.setEmail("tester123@gmail.com");
        person.setFirstName("max Ma");
        person.setIsRenter(true);
        person.setPassword("HashPassword");


        var returnPerson = personService.savePeople(person);

        var obtainPerson = personService.getPersonById(returnPerson.getId()).get();

        assertEquals(obtainPerson.getId(), returnPerson.getId());

        personService.deletePerson(returnPerson.getId());

    }

    @Test
    void savePeople() {

        Person person = new Person();
        person.setEmail("tester123@gmail.com");
        person.setFirstName("max Ma");
        person.setIsRenter(true);
        person.setPassword("HashPassword");


        var returnPerson = personService.savePeople(person);

        assertEquals(person.getEmail(), returnPerson.getEmail() );

        personService.deletePerson(returnPerson.getId());

    }
}