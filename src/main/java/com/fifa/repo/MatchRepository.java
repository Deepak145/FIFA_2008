package com.fifa.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fifa.entity.Match;

public interface MatchRepository extends ReactiveMongoRepository<Match, Integer >{

}
