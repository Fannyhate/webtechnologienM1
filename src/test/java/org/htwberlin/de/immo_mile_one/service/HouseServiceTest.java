package org.htwberlin.de.immo_mile_one.service;

import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HouseServiceTest {

    @Autowired
    private HouseService houseService;

    @Autowired
    private PersonService personService;


    @Test
    void getHouses() {

        House house = new House();
        house.setLocation("Berlin ");
        house.setFloor(2);
        house.setPrice(223.98);
        house.setRoom(2);

        Person person = new Person();
        person.setEmail("tester123@gmail.com");
        person.setFirstName("max Ma");
        person.setIsRenter(true);
        person.setPassword("HashPassword");


        var returnPerson = personService.savePeople(person);

        if(returnPerson != null){
            house.setMyHome(returnPerson);
        }

        var houseObject =houseService.saveHouse(house);
        houseService.deleteHouse(houseObject.getId());
        personService.deletePerson(returnPerson.getId());


    }

}