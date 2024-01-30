package org.htwberlin.de.immo_mile_one.repository;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  IPersonCrudRepository extends CrudRepository <Person, Long > {

    Optional<Person> findById(long personId);
    List<Person>findPersonByEmailOrRenter(String email, boolean renter);
    Person findAllByEmailAndPassword(String email, String password);


    /*
    Person addMyHome (House house);

     */

}
