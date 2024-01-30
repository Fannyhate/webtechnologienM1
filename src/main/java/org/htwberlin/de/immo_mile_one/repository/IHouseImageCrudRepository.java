package org.htwberlin.de.immo_mile_one.repository;

import org.htwberlin.de.immo_mile_one.model.HouseImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHouseImageCrudRepository extends CrudRepository<HouseImage,Long> {

}
