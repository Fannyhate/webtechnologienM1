package org.htwberlin.de.immo_mile_one.service;

import org.htwberlin.de.immo_mile_one.model.HouseImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.temporal.ValueRange;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HouseImageServiceTest {

    @Autowired
    private HouseImageService houseImageService;
    @Test
    void addImages() {
        HouseImage houseImage = new HouseImage();
        houseImage.setUrlImg("https://images.pexels.com/photos/186077/pexels-photo-186077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");

        var returnImage = houseImageService.addImages(houseImage);
        assertEquals(true,returnImage.getId()> 0);
    }

    @Test
    void addImageToHouse() {
    }
}