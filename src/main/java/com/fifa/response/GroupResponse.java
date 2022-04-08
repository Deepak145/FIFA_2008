package com.fifa.response;

public class GroupResponse {

	private String id;
	private String name;
    private String winner;
    private String runnerup;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getRunnerup() {
		return runnerup;
	}
	public void setRunnerup(String runnerup) {
		this.runnerup = runnerup;
	}
    
    
}
