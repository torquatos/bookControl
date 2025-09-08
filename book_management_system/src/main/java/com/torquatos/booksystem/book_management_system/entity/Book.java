package com.torquatos.booksystem.book_management_system.entity;

import javax.persistence.*;
import java.time.LocalDate;

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
	

}