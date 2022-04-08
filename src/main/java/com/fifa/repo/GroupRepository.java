package com.fifa.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fifa.entity.Group;

public interface GroupRepository extends ReactiveMongoRepository<Group, Integer >{

}
