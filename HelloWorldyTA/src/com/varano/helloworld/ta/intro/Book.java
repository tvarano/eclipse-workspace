//Thomas Varano
//Sep 4, 2018

package com.varano.helloworld.ta.intro;

public class Book {
	private String title, author, genre;
	private double price;
	private int amtPages;
	
	public Book(String title, String author, int amtPages, double price) {
		this.title = title;
		this.author = author;
		this.amtPages = amtPages;
		this.price = price;
	}

	public void setDiscount(double percentOff) {
		price *= (1-percentOff);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmtPages() {
		return amtPages;
	}
	public void setAmtPages(int amtPages) {
		this.amtPages = amtPages;
	}
	
	
}
