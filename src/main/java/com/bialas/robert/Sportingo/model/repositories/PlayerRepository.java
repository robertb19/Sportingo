package com.bialas.robert.Sportingo.model.repositories;

import com.bialas.robert.Sportingo.model.entities.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>{

    List<Player> findPlayersBySearching(boolean searching);

    Optional<Player> findByPlayerid(int id);

}
