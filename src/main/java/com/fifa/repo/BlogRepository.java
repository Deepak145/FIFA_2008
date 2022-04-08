package com.fifa.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fifa.response.Blogs;

public interface BlogRepository extends ReactiveMongoRepository<Blogs, String> {

}
