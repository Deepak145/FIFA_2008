package com.fifa.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fifa.entity.Channels;

public interface ChannelRepository extends ReactiveMongoRepository<Channels,Integer>{

}
