package com.fifa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fifa.repo.BlogRepository;
import com.fifa.response.Blogs;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BlogService {

	@Autowired private BlogRepository repository;
	
	public Flux<Blogs> load() {
		return repository.findAll();
	}
	
	public void add(Blogs blogs) {
		Blogs copy = new Blogs();
		copy.setLikes(blogs.getLikes());
		copy.setMessage(blogs.getMessage());
		copy.setMessages(blogs.getMessages());
		repository.save(copy).subscribe();
	}
	
	public void update(Blogs blogs) {
		Mono<Blogs> blog = repository.findById(blogs.getId());
		Blogs existing = blog.block();
		existing.setLikes(blogs.getLikes());
		existing.setMessage(blogs.getMessage());
		existing.setMessages(blogs.getMessages());
		repository.save(existing).subscribe();
	}
}
