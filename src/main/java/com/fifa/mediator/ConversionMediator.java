package com.fifa.mediator;

import org.bson.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fifa.mapper.ChannelJsonMapper;
import com.fifa.mapper.GroupJsonMapper;
import com.fifa.mapper.MatchJsonMapper;
import com.fifa.mapper.StadiumJsonMapper;
import com.fifa.mapper.TeamJsonMapper;

@Component
public class ConversionMediator {

	@Autowired
	private ChannelJsonMapper channels;
	@Autowired
	private GroupJsonMapper groups;
	@Autowired
	private MatchJsonMapper matches;
	@Autowired
	private StadiumJsonMapper stadium;
	@Autowired
	private TeamJsonMapper team;

	Logger log = LoggerFactory.getLogger(ConversionMediator.class);

	public void convert(String data) throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(data);
		if (node.get("stadiums") != null) {
			stadium.mapper(node.get("stadiums"));
			log.info("stadiums data is getting loaded to database");
		} else
			log.info("No Stadiums found the the file."+ node.isArray());
		
		if (node.get("tvchannels") != null) {
			channels.mapper(node.get("tvchannels"));
			log.info("Channels data is getting loaded to database");
		} else
			log.info("No Channels found the the file."+ node.isArray());
		
		if (node.get("teams") != null) {
			team.mapper(node.get("teams"));
			log.info("Teams data is getting loaded to database");
		} else
			log.info("No Teams found the the file."+ node.isArray());
		
		if (node.get("groups") != null) {
			groups.mapper(node.get("groups"));
			log.info("groups data is getting loaded to database");
		} else
			log.info("No groups found the the file."+ node.isArray());
		
		if (node.get("knockout") != null) {
			matches.mapper(node.get("knockout"));
			log.info("knockout data is getting loaded to database");
		} else
			log.info("No knockout found the the file."+ node.isArray());
	}
}
