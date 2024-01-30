package org.htwberlin.de.immo_mile_one.repository;
import org.htwberlin.de.immo_mile_one.model.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHouseCrudRepository  extends CrudRepository<House, Long > {
    Optional<House> findById(Long houseId );

    List<House> findHouseByRoomOrAndLocation(int room, String Location);


}
