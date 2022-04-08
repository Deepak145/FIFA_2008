package com.fifa.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fifa.entity.MatchType;

public class MatchResponse {
	private String name;
    private String type;
    private String home_team;
    private String away_team;
    private int home_result;
    private int away_result;
    private int home_penalty;
    private int away_penalty;
    private String winner;
    private LocalDateTime date;
    private String stadium;
    private List<String> channels;
    private boolean finished;
    private int matchday;
    private MatchType matchType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHome_team() {
		return home_team;
	}
	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}
	public String getAway_team() {
		return away_team;
	}
	public void setAway_team(String away_team) {
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
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public List<String> getChannels() {
		return channels;
	}
	public void setChannels(List<String> channels) {
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
