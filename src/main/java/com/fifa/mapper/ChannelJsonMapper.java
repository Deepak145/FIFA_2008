package com.fifa.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fifa.entity.Channels;
import com.fifa.repo.ChannelRepository;

@Component
public class ChannelJsonMapper implements JsonMapper {

	Logger log = LoggerFactory.getLogger(ChannelJsonMapper.class);

	@Autowired
	private ChannelRepository repository;

	@Override
	public void mapper(JsonNode node) {
		log.info("Team json is getting created ");
		if (node.isArray()) {
			for (JsonNode json : node) {
				Channels channel = new Channels();
				channel.setId(json.get("id").asInt());
				channel.setIcon(json.get("icon").asText());
				channel.setName(json.get("name").asText());
				channel.setCountry(json.get("country").asText());
				channel.setIso2(json.get("iso2").asText());
				List<String> langs = new ArrayList<>();
				for (JsonNode innerNode : json.get("lang")) {
					langs.add(innerNode.asText());
				}
				channel.setLang(langs);
				log.info("stadium is saved {}", channel.getName());
				repository.save(channel).subscribe();
			}
		}
	}

}
