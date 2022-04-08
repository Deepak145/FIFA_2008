package com.fifa.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fifa.entity.Stadium;

@Repository
public interface StadiumRepository extends ReactiveMongoRepository<Stadium, Integer >{

}
