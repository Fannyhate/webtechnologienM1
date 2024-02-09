package org.htwberlin.de.immo_mile_one.controller;

import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.HousePreference;
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

    @GetMapping("/api/persons_ref")
    public HousePreference getPersonReference( @RequestParam long personId) {
        return personService.getHousePreferenceByPerson(personId);
    }

    @GetMapping("/api/refs")
    public List<HousePreference> getReference( @RequestParam  boolean hasLift, @RequestParam double maxPrice,
                                               @RequestParam String location, @RequestParam int numberOfRoom) {
        return personService.getPreferences(hasLift, maxPrice, location, numberOfRoom );
    }
    @PostMapping("/api/person_ref")
    public HousePreference addPersonHousePreference(@RequestBody HousePreference housePreference) {
        return personService.addPersonPreference(housePreference);
    }

    @PutMapping("api/person_ref")
    public HousePreference UpdateHousePreference(@RequestParam long personId, @RequestBody HousePreference housePreference){
        return  personService.updatePersonPreference(personId, housePreference);
    }

}
