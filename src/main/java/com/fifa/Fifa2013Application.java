package com.fifa;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fifa.mediator.ConversionMediator;
import com.fifa.repo.ChannelRepository;
import com.fifa.repo.GroupRepository;
import com.fifa.repo.MatchRepository;
import com.fifa.repo.StadiumRepository;
import com.fifa.repo.TeamsRepository;

@SpringBootApplication
@EnableMongoRepositories
public class Fifa2013Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Fifa2013Application.class, args);
	}

	@Autowired
	ChannelRepository ch;
	@Autowired
	GroupRepository grp;
	@Autowired
	MatchRepository match;
	@Autowired
	StadiumRepository std;
	@Autowired
	TeamsRepository teams;

	@Value("classpath:fifa.json")
	private Resource resource;
	@Autowired
	private ConversionMediator mediator;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * ch.deleteAll().subscribe(); grp.deleteAll().subscribe();
		 * match.deleteAll().subscribe(); std.deleteAll().subscribe();
		 * teams.deleteAll().subscribe();
		 * 
		 * if (resource.exists()) { Path path = Paths.get(resource.getFile().toURI());
		 * byte[] reader = Files.readAllBytes(path); mediator.convert(new
		 * String(reader)); }
		 */
	}

}
