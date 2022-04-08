package com.fifa.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fifa.entity.Group;
import com.fifa.entity.Match;
import com.fifa.entity.MatchType;
import com.fifa.repo.GroupRepository;

@Component
public class GroupJsonMapper implements JsonMapper {

	Logger log = LoggerFactory.getLogger(GroupJsonMapper.class);
	@Autowired private GroupRepository repository;
	@Autowired private MatchJsonMapper matchMapper;

	@Override
	public void mapper(JsonNode node) {
		log.info("Team json is getting created {}");
		char groupId = 'a';
		for (char grp = groupId; grp <= 'h'; grp++) {
			JsonNode innerA = node.get(String.valueOf(grp));

			Group group = new Group();
			group.setName(innerA.get("name").asText());
			group.setWinner(innerA.get("winner").asInt());
			group.setRunnerup(innerA.get("runnerup").asInt());
			log.info("stadium is saved {}", group.getName());

			repository.save(group).subscribe();

			for (JsonNode matches : innerA.get("matches")) {
				if(matches.get("name") == null ) return;
				Match match = new Match();
			    match.setMatchType(MatchType.GROUP);
				matchMapper.mapper(match, matches);
			}
		}
	}
}