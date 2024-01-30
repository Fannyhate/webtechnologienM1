package org.htwberlin.de.immo_mile_one.service;

import org.htwberlin.de.immo_mile_one.model.House;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.htwberlin.de.immo_mile_one.repository.IHouseCrudRepository;
import org.htwberlin.de.immo_mile_one.repository.IPersonCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    @Autowired
    private IHouseCrudRepository houseCrudRepository;

    @Autowired
    private IPersonCrudRepository personCrudRepository;


    public  House getHouseById(Long id){
        return this.houseCrudRepository.findById(id).orElseThrow();
    }
    public List<House> getHouses(){
        return (List<House>) houseCrudRepository.findAll();
    }


    public List<House> getFilterByPricesInterval(double fromPrice, double toPrice){
        var houses = houseCrudRepository.findAll();

        var filteredHouses = new ArrayList<House>();
        houses.forEach( (house -> {
            if(house.getPrice() <= toPrice){
                if(house.getPrice() >=  fromPrice){
                    filteredHouses.add(house);
                }
            }
        }));
        return  filteredHouses;
    }
    public List<House> getHouseFilterByLocationAndRoom(int room, String location){
        return houseCrudRepository.findHouseByRoomOrAndLocation(room,location);
    }
    public void saveHouse(House house){
      houseCrudRepository.save(house);

    }
    public  House updateHouse(long house_id, House house){
        var oldHouse = houseCrudRepository.findById(house_id);
        var oldHouseValue = oldHouse.orElseThrow();

        if(houseCrudRepository.existsById(house_id)){

            //oldHouseValue = house;
            oldHouseValue.setHouseImages(house.getHouseImages());
            oldHouseValue.setFloor(house.getFloor());
            oldHouseValue.setLocation(house.getLocation());

            houseCrudRepository.save(oldHouseValue);
        }
        return houseCrudRepository.findById(house_id).orElseThrow();
    }

    public  void deleteHouse(long house_id){
        var house = houseCrudRepository.findById(house_id);
        var houseValue = house.orElseThrow();
        houseValue.getPerson_apply_house().clear();

        houseCrudRepository.deleteById(house_id);
    }

    private boolean checkPerson (long personId , List<Person> people){

        for ( var persons: people) {
            if(persons.getId() == personId){
                return true;
            }
        }
        return  false;
   }


    public House removeApplier(long house_id, long person_id){

        var house = houseCrudRepository.findById(house_id);
        var person = personCrudRepository.findById(person_id);

        var houseValue = house.orElseThrow();
        var personValue = person.orElseThrow();

        var personsApplies = houseValue.getPerson_apply_house();
        if(checkPerson(person_id, personsApplies.stream().toList())){

            personsApplies.remove( personValue);

            houseValue.setPerson_apply_house(personsApplies);
            houseCrudRepository.save(houseValue);
        }


        return houseCrudRepository.findById(house_id).orElseThrow();
    }

    public House addApplier(long house_id, long person_id){

        var house = houseCrudRepository.findById(house_id);
        var person = personCrudRepository.findById(person_id);

        var houseValue = house.orElseThrow();
        var personValue = person.orElseThrow();

        //TODO Check existing person in the applied Persons
        var personsApplies = houseValue.getPerson_apply_house();
        if(!checkPerson(person_id, personsApplies.stream().toList())){

            personsApplies.add( personValue);

            houseValue.setPerson_apply_house(personsApplies);
            houseCrudRepository.save(houseValue);
        }

        return houseCrudRepository.findById(house_id).orElseThrow();
    }



}
