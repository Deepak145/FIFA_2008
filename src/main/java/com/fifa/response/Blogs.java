package com.fifa.response;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Document(collection = "Commets")
public class Blogs {

	@Id
	private String id;
	
	private String message;
	private int likes;
	private List<BlogsReply> messages;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public List<BlogsReply> getMessages() {
		return messages;
	}
	public void setMessages(List<BlogsReply> messages) {
		this.messages = messages;
	}
	
}
