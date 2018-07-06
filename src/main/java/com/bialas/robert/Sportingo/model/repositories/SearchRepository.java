package com.bialas.robert.Sportingo.model.repositories;

import com.bialas.robert.Sportingo.model.entities.Search;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends CrudRepository<Search, Integer> {

}
