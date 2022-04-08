package com.fifa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.response.StadiumResponse;
import com.fifa.service.StadiumService;

import reactor.core.publisher.Flux;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/stadium")
public class StadiumController {

	@Autowired private StadiumService service;
	
	@GetMapping
	public Flux<StadiumResponse> get() {
		return service.stadiums();
	}
}
