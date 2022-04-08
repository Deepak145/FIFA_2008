package com.fifa.response;

public class TeamsResponse {
	 private int id;
     private String name;
     private String fifaCode;
     private String iso2;
     private String flag;
     private String emoji;
     private String emojiString;
     private int played;
     private int won;
     private int loss;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFifaCode() {
		return fifaCode;
	}
	public void setFifaCode(String fifaCode) {
		this.fifaCode = fifaCode;
	}
	public String getIso2() {
		return iso2;
	}
	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	public String getEmojiString() {
		return emojiString;
	}
	public void setEmojiString(String emojiString) {
		this.emojiString = emojiString;
	}
	public int getPlayed() {
		return played;
	}
	public void setPlayed(int played) {
		this.played = played;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
	}
}
