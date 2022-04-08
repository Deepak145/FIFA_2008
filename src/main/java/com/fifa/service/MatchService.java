package com.fifa.service;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fifa.entity.Channels;
import com.fifa.entity.Match;
import com.fifa.entity.Stadium;
import com.fifa.entity.Teams;
import com.fifa.repo.ChannelRepository;
import com.fifa.repo.MatchRepository;
import com.fifa.repo.StadiumRepository;
import com.fifa.repo.TeamsRepository;
import com.fifa.response.MatchResponse;

import reactor.core.publisher.Flux;

@Component
public class MatchService {
	
	@Autowired
	private MatchRepository repository;
	
	@Autowired 
	private TeamsRepository teamRepository;
	
	@Autowired
	private StadiumRepository stadiumRepository;
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@PostConstruct
	public void inti() {
		setupTeams();
		setupChannel();
		setupStadium();
	}
	
	private List<Teams> teams;
	private List<Stadium> std;
	private List<Channels> channel;

	public Flux<MatchResponse> match() {
		return repository.findAll().flatMap(k -> {
			MatchResponse resp = new MatchResponse();
			resp.setAway_penalty(k.getAway_penalty());
			resp.setAway_result(k.getAway_result());
			resp.setFinished(k.isFinished());
			resp.setHome_penalty(k.getHome_penalty());
			resp.setHome_result(k.getHome_result());
			resp.setMatchday(k.getMatchday());
			resp.setMatchType(k.getMatchType());
			resp.setDate(k.getDate());
			
			Predicate<Teams> predicate = e -> e.getId() == k.getAway_team();
			resp.setAway_team(teams.stream().filter(predicate).map(e -> e.getName()).findFirst().get());
			
			Predicate<Teams> homeTeam = e -> e.getId() == k.getHome_team();
			resp.setHome_team(teams.stream().filter(homeTeam).map(e -> e.getName()).findFirst().get());
			
			Predicate<Teams> winner = e -> e.getId() == k.getWinner();
			resp.setWinner(teams.stream().filter(winner).map(e -> e.getName()).findFirst().orElse(""));
			
			Predicate<Stadium> stdPredicate = e -> e.getId() == k.getStadium();
			resp.setStadium(std.stream().filter(stdPredicate).map(e -> e.getName()).findFirst().orElse(""));
			
			Predicate<Channels> chPredicate = e -> k.getChannels().contains(e.getId());
			List<String> channelList = channel.stream().filter(chPredicate).map(Channels::getName).collect(Collectors.toList());
			resp.setChannels(channelList);
			return Flux.just(resp);
		});
	}

	private void setupStadium() {
		this.teams = teamRepository.findAll().collect(Collectors.toList()).block();
	}

	private void setupChannel() {
		this.std = stadiumRepository.findAll().collect(Collectors.toList()).block();
		
	}

	private void setupTeams() {
		this.channel = channelRepository.findAll().collect(Collectors.toList()).block();
		
	}
}
