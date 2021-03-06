package com.bialas.robert.Sportingo.model.repositories;

import com.bialas.robert.Sportingo.model.entities.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
