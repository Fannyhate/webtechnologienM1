package org.htwberlin.de.immo_mile_one.service;
import org.htwberlin.de.immo_mile_one.model.HousePreference;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.htwberlin.de.immo_mile_one.repository.IHousePreferenceCrudRepository;
import org.htwberlin.de.immo_mile_one.repository.IPersonCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private IPersonCrudRepository personCrudRepository;

    @Autowired
    private IHousePreferenceCrudRepository housePreferenceCrudRepository;

    public List<Person> getPeople(){
        return (List<Person>) personCrudRepository.findAll();
    }

    public Optional<Person> getPersonById (Long personId){
        return  personCrudRepository.findById(Long.valueOf(personId));
    }

    //TODO delete and Update Person information
    //TODO remove by Applying Houses

    public Person savePeople(Person person){
        return personCrudRepository.save(person);
    }

    public void deletePerson(long personId){
        var Person =personCrudRepository.findById(personId);
        var PersonValue=Person.orElseThrow();
        personCrudRepository.delete(PersonValue);
    }

    public Person updatePerson (long personId , Person person){
        var oldPerson =personCrudRepository.findById(personId);
        var oldPersonValue= oldPerson.orElseThrow();

        if(personCrudRepository.existsById(oldPersonValue.getId())){
            oldPersonValue.setOccupation(person.getOccupation());
            oldPersonValue.setPassword(oldPersonValue.getPassword());
        }

        personCrudRepository.save(oldPersonValue);
        return personCrudRepository.findById(personId).orElseThrow();
    }

    public HousePreference addPersonPreference(HousePreference housePreference){
        var personPrefs = housePreferenceCrudRepository.findByPerson(housePreference.getPerson());
        if (personPrefs == null){
            return housePreferenceCrudRepository.save(housePreference);
        }

        return  null;
    }

    public  HousePreference getHousePreferenceByPerson(long personId){
        Person person = personCrudRepository.findById(personId).orElseThrow();
        HousePreference oldHousePreference = housePreferenceCrudRepository.findByPerson(person);
        return  oldHousePreference;
    }

    public HousePreference updatePersonPreference(long personId, HousePreference housePreference){

        Person person = personCrudRepository.findById(personId).orElseThrow();
        HousePreference oldHousePreference = housePreferenceCrudRepository.findByPerson(person);

        if(housePreferenceCrudRepository.existsById(oldHousePreference.getId())){
            oldHousePreference.setHasLift(housePreference.isHasLift());
            oldHousePreference.setLocation(housePreference.getLocation());
            oldHousePreference.setMaxPrice(housePreference.getMaxPrice());
            oldHousePreference.setNumberOfRoom(housePreference.getNumberOfRoom());
        }

        return housePreferenceCrudRepository.save(oldHousePreference);
    }

    public Person loginPerson(String email, String password){
        return personCrudRepository.findAllByEmailAndPassword(email, password);
    }

    public List<HousePreference> getPreferences(boolean hasLift, double maxPrice, String location, int numberOfRoom){
        return  housePreferenceCrudRepository.findAllByHasLiftAndMaxPriceGreaterThanEqualAndLocationContainsIgnoreCaseAndNumberOfRoom(
                hasLift, maxPrice, location, numberOfRoom
        );
    }
}
