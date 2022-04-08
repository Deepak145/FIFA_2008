package com.fifa.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fifa.entity.Match;
import com.fifa.entity.MatchType;
import com.fifa.repo.MatchRepository;

@Component
public class MatchJsonMapper implements JsonMapper {

	Logger log = LoggerFactory.getLogger(MatchJsonMapper.class);
	@Autowired
	MatchRepository matchRepo;

	@Override
	public void mapper(JsonNode json) {
		log.info("Team json is getting created {}");
		List<String> knockout = Arrays.asList("round_16", "round_8", "round_4", "round_2_loser", "round_2");
		knockout.forEach(k -> {
			JsonNode round16 = json.get(k);
			JsonNode mat = round16.get("matches");
			for (JsonNode matches : mat) {
				Match match = new Match();
				switch (k) {
				case "round_16": {
					match.setMatchType(MatchType.ROUND_16);
					if(matches.get("name") == null ) return;
					this.mapper(match, matches);
					break;
				}
				case "round_8": {
					match.setMatchType(MatchType.ROUND_8);
					if(matches.get("name") == null ) return;
					this.mapper(match, matches);
					break;
				}
				case "round_4": {
					match.setMatchType(MatchType.ROUND_4);
					if(matches.get("name") == null ) return;
					this.mapper(match, matches);
					break;
				}
				case "round_2_loser": {
					match.setMatchType(MatchType.ROUND_2_LOSER);
					if(matches.get("name") == null ) return;
					this.mapper(match, matches);
					break;
				}
				case "round_2": {
					match.setMatchType(MatchType.ROUND_2);
					if(matches.get("name") == null ) return;
					this.mapper(match, matches);
					break;
				}
				default : break;
				}
			}
		});

	}

	public void mapper(Match match, JsonNode matches) {
		match.setName(matches.get("name").asInt());
		match.setType(matches.get("type").asText());
		match.setHome_team(matches.get("home_team").asInt());
		match.setAway_team(matches.get("away_team").asInt());
		match.setHome_result(matches.get("home_result").asInt());
		match.setAway_result(matches.get("away_result").asInt());
		match.setStadium(matches.get("stadium").asInt());
		match.setFinished(matches.get("finished").asBoolean());
		match.setMatchday(matches.get("matchday").asInt());
		match.setWinner((matches.get("winner")!= null )?matches.get("winner").asInt(): -1);
		
		LocalDateTime datel = LocalDateTime.parse(matches.get("date").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
		match.setDate(datel);
		List<Integer> channels = new ArrayList<>();
		for (JsonNode ch : matches.get("channels")) {
			channels.add(ch.asInt());
		}
		match.setChannels(channels);
		matchRepo.save(match).subscribe();
	}
}
