package org.htwberlin.de.immo_mile_one.service;

import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.HouseImage;
import org.htwberlin.de.immo_mile_one.repository.IHouseCrudRepository;
import org.htwberlin.de.immo_mile_one.repository.IHouseImageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseImageService {

    @Autowired
    private IHouseImageCrudRepository houseImageCrudRepository;

    @Autowired
    private IHouseCrudRepository houseCrudRepository;

    public List<HouseImage> gethouse(){
        return(List<HouseImage>) houseImageCrudRepository;
    }
    public HouseImage addImages(HouseImage houseImage){
        var houseImageID = houseImageCrudRepository.save(houseImage).getId();
        return houseImageCrudRepository.findById(houseImageID).orElseThrow();
    }

    public House addImageToHouse(long houseId, long imageId){

        var house = houseCrudRepository.findById(houseId);
        var image = houseImageCrudRepository.findById(imageId);

        var houseValue = house.orElseThrow();
        var imageValue = image.orElseThrow();

        var imagesHouse = houseValue.getHouseImages();
        imagesHouse.add(imageValue);
        houseValue.setHouseImages(imagesHouse);

        return  houseCrudRepository.save(houseValue);
    }
}
