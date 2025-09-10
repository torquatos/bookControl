package com.torquatos.booksystem.book_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")

public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String author;
	private String genre;
	private String publisher;
	private int year;
	private String summary;
	private boolean wasRead;
	private boolean wantToRead;
	private double rate;
	private String personalNotes;
	private boolean readAgain;
	
	public Book() {
		
	}
	
	public Book(String name, String author, String genre, String publisher, int year, String summary, double rate, String personalNotes) {
	this.name = name;
	this.author = author;
	this.genre = genre;
	this.publisher = publisher;
	this.year = year;
	this.summary = summary;
	this.wasRead = false;
	this.wantToRead = false;
	this.rate = rate;
	this.personalNotes = personalNotes;
	this.readAgain = false;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor (String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void getSummary(String summary) {
		this.summary = summary;
	}
	
	public boolean getWasRead() {
		return wasRead;
	}
	
	public void setWasRead(boolean wasRead) {
		this.wasRead = wasRead;
	}
	
	public boolean getWantToRead() {
		return wantToRead;
	}
	
	public void setWantToRead(boolean wantToRead) {
		this.wantToRead = wantToRead;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public String getPersonalNotes() {
		return personalNotes;
	}
	
	public void setPersonalNotes(String personalNotes) {
		this.personalNotes = personalNotes;
	}
	
	public boolean getReadAgain () {
		return readAgain;
	}
	
	public void setReadAgain(boolean readAgain){
		this.readAgain = readAgain;
	}

}