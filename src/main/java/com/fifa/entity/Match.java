package com.fifa.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("Match")
public class Match {
	@Id
	 private int name;
     private String type;
     private int home_team;
     private int away_team;
     private int home_result;
     private int away_result;
     private int home_penalty;
     private int away_penalty;
     private int winner;
     private LocalDateTime date;
     private int stadium;
     private List<Integer> channels;
     private boolean finished;
     private int matchday;
     
     private MatchType matchType;
     
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHome_team() {
		return home_team;
	}
	public void setHome_team(int home_team) {
		this.home_team = home_team;
	}
	public int getAway_team() {
		return away_team;
	}
	public void setAway_team(int away_team) {
		this.away_team = away_team;
	}
	public int getHome_result() {
		return home_result;
	}
	public void setHome_result(int home_result) {
		this.home_result = home_result;
	}
	public int getAway_result() {
		return away_result;
	}
	public void setAway_result(int away_result) {
		this.away_result = away_result;
	}
	public int getHome_penalty() {
		return home_penalty;
	}
	public void setHome_penalty(int home_penalty) {
		this.home_penalty = home_penalty;
	}
	public int getAway_penalty() {
		return away_penalty;
	}
	public void setAway_penalty(int away_penalty) {
		this.away_penalty = away_penalty;
	}
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getStadium() {
		return stadium;
	}
	public void setStadium(int stadium) {
		this.stadium = stadium;
	}
	public List<Integer> getChannels() {
		return channels;
	}
	public void setChannels(List<Integer> channels) {
		this.channels = channels;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public int getMatchday() {
		return matchday;
	}
	public void setMatchday(int matchday) {
		this.matchday = matchday;
	}
	public MatchType getMatchType() {
		return matchType;
	}
	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}
}
