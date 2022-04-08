package com.fifa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fifa.response.ChannelResponse;
import com.fifa.service.ChannelService;

import reactor.core.publisher.Flux;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/channels")
public class ChannelsController {

	@Autowired private ChannelService service;
	
	@GetMapping
	public Flux<ChannelResponse> get() {
		return service.channel();
	}
}
