package com.fifa.response;

public class StadiumResponse {
	private int id;
    private String name;
    private String city;
    private double lat;
    private double lng;
    private String image;
    private int matchCount;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getMatchCount() {
		return matchCount;
	}
	public void setMatchCount(int matchCount) {
		this.matchCount = matchCount;
	}
    
    
}
