package org.htwberlin.de.immo_mile_one.controller;
import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.HouseImage;
import org.htwberlin.de.immo_mile_one.service.EmailService;
import org.htwberlin.de.immo_mile_one.service.HouseImageService;
import org.htwberlin.de.immo_mile_one.service.HouseService;
import org.htwberlin.de.immo_mile_one.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  ImmoMileOneController {

    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseImageService houseImageService;

    @Autowired
    private PersonService personService;

    @Autowired
    private EmailService emailService;


    @GetMapping("/api/house")
    public House GetHouse(@RequestParam long id) {
        return houseService.getHouseById(id);
    }

    @GetMapping("api/filter_house")
    public List<House> getFilterHouse (@RequestParam int room, @RequestParam String location ){
        return houseService.getHouseFilterByLocationAndRoom (room, location);
    }

    @GetMapping("api/filter_house_prices")
    public List<House> getFilterHouse (@RequestParam double fromPrice, @RequestParam double toPrice ){
        return houseService.getFilterByPricesInterval (fromPrice, toPrice);
    }

    @GetMapping("api/houses")
    public List<House> getHouses(){
        return houseService.getHouses();
    }
    @PostMapping("api/house")
    public void addHouse(@RequestBody House house) {
       var returnHouse =  houseService.saveHouse(house);
       var personsPreference = personService.getPreferences(returnHouse.getLift(), returnHouse.getPrice(), returnHouse.getLocation(), returnHouse.getRoom());

        for (var personPrefs: personsPreference) {
            emailService.sendEmailFirstContact(personPrefs, returnHouse);
        }

    }

    @PostMapping("api/apply_house")
    public void addHouse(@RequestParam long house_id, @RequestParam long  person_id) {
        houseService.addApplier(house_id, person_id);
    }

    @PostMapping("api/houseImage")
    public HouseImage addHouseImage(@RequestBody HouseImage houseImage) {
        return houseImageService.addImages(houseImage);
    }

    @PostMapping("api/addImageHouse")
    public House addImageToHouse(@RequestParam long houseId, @RequestParam long  imageId) {
        return houseImageService.addImageToHouse(houseId, imageId);
    }
    @DeleteMapping("api/deletePersonFromHouse")
    public House deletePersonToHouse(@RequestParam long personId,@RequestParam long houseId){
        return houseService.removeApplier(personId,houseId);
    }

    @DeleteMapping("api/deleteHouse")
    public void deleteHouse(@RequestParam long houseId){
        houseService.deleteHouse(houseId);
    }

    @PutMapping("api/house")
    public House UpdateHouse(@RequestParam long houseId, @RequestBody House house){
        return  houseService.updateHouse(houseId, house);
    }

}
