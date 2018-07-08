package com.bialas.robert.Sportingo.model.repositories;

import com.bialas.robert.Sportingo.model.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    boolean existsByLogin(String login);

    Optional<UserEntity> findByLoginAndPassword(String login, String password);

}
