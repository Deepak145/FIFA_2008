package com.fifa.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "channels")
public class Channels {
	@Id
	private int id;
    private String name;
    private String icon;
    private String country;
    private String iso2;
    private List<String> lang;
    
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIso2() {
		return iso2;
	}
	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}
	public List<String> getLang() {
		return lang;
	}
	public void setLang(List<String> lang) {
		this.lang = lang;
	}
	
}
