package com.torquatos.booksystem.book_management_system.config;

import com.torquatos.booksystem.book_management_system.repo.*;
import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.*;

@SpringBootApplication
@ComponentScan(basePackages = "com.torquatos.booksystem.book_management_system.config")

public class BookApplication{
	
	public static void main(String[] args) {
		SpringApplicattion.run(BookApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner createTable (BookRepository repository) {
		return (args) -> {
			String url = "jdbc:sqlite:books.db";
			String sql = 'CREATE TABLE IF NOT EXISTS books ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "")'
		}
	}
}

