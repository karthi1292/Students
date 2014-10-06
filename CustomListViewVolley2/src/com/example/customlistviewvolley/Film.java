package com.example.customlistviewvolley;

import java.util.ArrayList;

public class Film {
	
	private String title;
	private String image;
	private double rating;
	private int releaseYear;
	private ArrayList<String> genre;
	
	
	public  void setTitle(String title) {
		this.title = title;
	}
	public  void setImage(String image) {
		this.image = image;
	}
	public  void setRating(double d) {
		this.rating = d;
	}
	public  void setReleaseyear(int releaseyear) {
		releaseYear = releaseyear;
	}
	public  void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	public  int getReleaseYear() {
		return releaseYear;
	}

	public  String getTitle() {
		return title;
	}
	public  String getImage() {
		return image;
	}
	public  double getRating() {
		return rating;
	}
	public ArrayList<String> getGenre() {
		return genre;
	}
	
	
	




}
