package com.fifa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groups")
public class Group {

	@Id
	private String id;
	 private String name;
     private int winner;
     private int runnerup;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
	public int getRunnerup() {
		return runnerup;
	}
	public void setRunnerup(int runnerup) {
		this.runnerup = runnerup;
	}
}
