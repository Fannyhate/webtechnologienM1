package org.htwberlin.de.immo_mile_one.service;

import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@RestController
class HouseServiceTest {

    @Autowired
    private HouseService houseService;

    @Autowired
    private PersonService personService;

    @Test
    void getHouseById() {

        var id = 2;
        var foundHouse = houseService.getHouseById((long) id);
        assertEquals(id, foundHouse.getId());
    }

    @Test
    void getHouses() {

        House house = new House();
        house.setLocation("Berlin ");
        house.setFloor(2);
        house.setPrice(223.98);
        house.setRoom(2);

        Person person = new Person();
        person.setEmail("tester@gmail.com");
        person.setFirstName("max Ma");
        person.setIsRenter(true);
        person.setPassword("HashPassword");

        var returnPerson = personService.savePeople(person);
        house.setMyHome(returnPerson);

        var houseObject =houseService.saveHouse(house);

        var getHouse = houseService.getHouses();

        assertEquals(true, getHouse.size()>0 );

    }

    @Test
    void saveHouse() {
    }

    @Test
    void updateHouse() {
    }

    @Test
    void deleteHouse() {
    }
}