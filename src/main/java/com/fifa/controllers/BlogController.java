package com.fifa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.response.Blogs;
import com.fifa.service.BlogService;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired BlogService service;
	
	@GetMapping(path = "/load")
	public Flux<Blogs> load() {
		return service.load();	
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Blogs object) {
		service.add(object);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Blogs object) {
		service.update(object);
	}
}
