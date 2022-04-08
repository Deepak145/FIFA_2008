package com.fifa.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fifa.entity.Teams;
import com.fifa.repo.TeamsRepository;

@Component
public class TeamJsonMapper  implements JsonMapper{

	Logger log = LoggerFactory.getLogger(TeamJsonMapper.class);
	@Autowired TeamsRepository repository;
	@Override
	public void mapper(JsonNode node) {
		log.info("Team json is getting created {}");
		log.info("Team json is getting created ");
		if(node.isArray()) {
			for(JsonNode json : node) {
			Teams teams = new Teams();
			teams.setId(json.get("id").asInt());
			teams.setName(json.get("name").asText());
			teams.setFifaCode(json.get("fifaCode").asText());
			teams.setFlag(json.get("flag").asText());
			teams.setEmoji(json.get("emoji").asText());
			teams.setEmojiString(json.get("emojiString").asText());
			log.info("stadium is saved {}", teams.getName());
			repository.save(teams).subscribe();
			}
		}
	}
}