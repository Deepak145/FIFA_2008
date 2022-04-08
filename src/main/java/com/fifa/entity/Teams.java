package com.fifa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Teams")
public class Teams {

	@Id
	 private int id;
     private String name;
     private String fifaCode;
     private String iso2;
     private String flag;
     private String emoji;
     private String emojiString;
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
     
     
}
