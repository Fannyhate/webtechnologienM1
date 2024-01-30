package org.htwberlin.de.immo_mile_one.service;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.htwberlin.de.immo_mile_one.repository.IPersonCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private IPersonCrudRepository personCrudRepository;

    public List<Person> getPeople(){
        return (List<Person>) personCrudRepository.findAll();
    }

    public Optional<Person> getPersonById (int personId){
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

    public Person updatePerson (long personId , Person Person){
        var oldPerson=personCrudRepository.findById(personId);
        var oldPersonValue= oldPerson.orElseThrow();
        oldPersonValue=Person;
        personCrudRepository.save(oldPersonValue);
        return personCrudRepository.findById(personId).orElseThrow();
    }

    public Person loginPerson(String email, String password){
        return personCrudRepository.findAllByEmailAndPassword(email, password);
    }
}
