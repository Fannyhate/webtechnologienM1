package org.htwberlin.de.immo_mile_one.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@RestController
class HouseServiceTest {

    @Autowired
    private HouseService houseService;

    @Test
    void getHouseById() {

        var id = 2;
        var foundHouse = houseService.getHouseById((long) id);
        assertEquals(id, foundHouse.getId());
    }

    @Test
    void getHouses() {
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