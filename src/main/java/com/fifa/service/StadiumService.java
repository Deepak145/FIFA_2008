package com.fifa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fifa.repo.StadiumRepository;
import com.fifa.response.StadiumResponse;

import reactor.core.publisher.Flux;

@Component
public class StadiumService {

	@Autowired StadiumRepository repository;
	
	public Flux<StadiumResponse> stadiums() {
		return repository.findAll().flatMap(k -> {
			StadiumResponse resp = new StadiumResponse();
			resp.setCity(k.getCity());
			resp.setId(k.getId());
			resp.setImage(k.getImage());
			resp.setLat(k.getLat());
			resp.setLng(k.getLng());
			resp.setName(k.getName());
			
			return Flux.just(resp);
		});
	}
	
}
