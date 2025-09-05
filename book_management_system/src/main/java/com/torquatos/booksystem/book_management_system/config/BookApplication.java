package com.torquatos.booksystem.book_management_system.config;

import com.torquatos.booksystem.book_management_system.repo.*;
import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.*;

@SpringBootApplication
@ComponentScan(basePackages = "com.torquatos.booksystem.book_management_system.config")

public class BookApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner createTable (BookRepository repository) {
		return (args) -> {
			String url = "jdbc:sqlite:books.db";
			String sql = "CREATE TABLE IF NOT EXISTS books ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "author TEXT NOT NULL,"
					+ "genre TEXT NOT NULL,"
					+ "publisher TEXT NOT NULL,"
					+ "year INTEGER NOT NULL,"
					+ "summary TEXT NOT NULL,"
					+ "wasRead INTEGER NOT NULL CHECK (wasRead IN (0, 1)),"
					+ "wantToRead INTEGER NOT NULL CHECK (wantToRead IN (0, 1)),"
					+ "rate DOUBLE,"
					+ "personalNotes TEXT,"
					+ "readAgain INTEGER NOT NULL CHECK (readAgain IN (0, 1))"
					+ ");";
			
			try (Connection conn = DriverManager.getConnection(url);
					Statement stmt = conn.createStatement()) {
				stmt.execute(sql);
				System.out.println("The Table 'Books' was succesfully created");			
				}
			
		};
	}
}

