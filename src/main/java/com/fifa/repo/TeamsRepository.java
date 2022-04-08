package com.fifa.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fifa.entity.Teams;

public interface TeamsRepository extends ReactiveMongoRepository<Teams, Integer >{

}
