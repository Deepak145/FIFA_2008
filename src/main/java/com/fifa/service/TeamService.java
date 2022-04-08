package com.fifa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fifa.entity.Teams;
import com.fifa.repo.TeamsRepository;
import com.fifa.response.TeamsResponse;

import reactor.core.publisher.Flux;

@Component
public class TeamService {

	@Autowired TeamsRepository repository;
	
	public Flux<TeamsResponse> team() {
		Flux<Teams> teams = repository.findAll();
		return teams.flatMap(k -> {
			TeamsResponse resp = new TeamsResponse();
			resp.setEmoji(k.getEmoji());
			resp.setEmojiString(k.getEmojiString());
			resp.setFifaCode(k.getFifaCode());
			resp.setFlag(k.getFlag());
			resp.setId(k.getId());
			resp.setIso2(k.getIso2());
			resp.setName(k.getName());
			return Flux.just(resp);
		});
	}	
}
