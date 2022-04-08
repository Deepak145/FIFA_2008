package com.fifa.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fifa.entity.Stadium;
import com.fifa.repo.StadiumRepository;

@Component
public class StadiumJsonMapper  implements JsonMapper{

	Logger log = LoggerFactory.getLogger(StadiumJsonMapper.class);
	
	@Autowired private StadiumRepository repository;
	
	@Override
	public void mapper(JsonNode node) {
		log.info("Team json is getting created ");
		if(node.isArray()) {
			for(JsonNode json : node) {
			Stadium stadium = new Stadium();
			stadium.setId(json.get("id").asInt());
			stadium.setName(json.get("name").asText());
			stadium.setCity(json.get("city").asText());
			stadium.setImage(json.get("image").asText());
			stadium.setLat(json.get("lat").asDouble());
			stadium.setLng(json.get("lng").asDouble());
			log.info("stadium is saved {}", stadium.getName());
			repository.save(stadium).subscribe();
			}
		}
	}

}
