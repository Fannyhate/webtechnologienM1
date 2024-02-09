package org.htwberlin.de.immo_mile_one.repository;

import org.htwberlin.de.immo_mile_one.model.HousePreference;
import org.htwberlin.de.immo_mile_one.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHousePreferenceCrudRepository extends CrudRepository <HousePreference, Long>{

    HousePreference findByPerson(Person person);
    List<HousePreference> findAllByHasLiftAndMaxPriceGreaterThanEqualAndLocationContainsIgnoreCaseAndNumberOfRoom(Boolean hasLift, double maxPrice, String location, int numberOfRoom);

}
