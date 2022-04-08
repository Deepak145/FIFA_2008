package com.fifa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fifa.repo.ChannelRepository;
import com.fifa.response.ChannelResponse;

import reactor.core.publisher.Flux;

@Component
public class ChannelService {

	@Autowired private ChannelRepository repository;
	
	public Flux<ChannelResponse> channel() {
		return repository.findAll().flatMap(k -> {
			ChannelResponse resp = new ChannelResponse();
			resp.setCountry(k.getCountry());
			resp.setIcon(k.getIcon());
			resp.setId(k.getId());
			resp.setIso2(k.getIso2());
			resp.setLang(k.getLang());
			resp.setName(k.getName());
			
			return Flux.just(resp);
		});
	}
}
