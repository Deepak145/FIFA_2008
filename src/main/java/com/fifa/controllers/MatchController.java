package com.fifa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.response.MatchResponse;
import com.fifa.service.MatchService;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/matches")
public class MatchController {
	
	@Autowired private MatchService matchService;

	@GetMapping
	public Flux<MatchResponse> getMatches(){
		return matchService.match();
	}
}
