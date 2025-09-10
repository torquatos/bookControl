package com.torquatos.booksystem.book_management_system.repo;

import com.torquatos.booksystem.book_management_system.entity.Book;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.*;

import java.time.LocalDate;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Book b SET b.wasRead = ?2 WHERE b.id = ?1")
	void updateBookStatus(Long bookId, boolean wasRead);
	
	@Transactional
	@Modifying
	@Query("UPDATE Book b SET b.name = ?2, b.author = ?3, b.genre = ?4, b.publisher = ?5, b.year = ?6, b.summary = ?7, b.wantToRead = ?8, b.rate = ?9, b.personalNotes = ?10, b.readAgain = ?11, b.id = ?1")
	void updateBookDetails(Long bookId, String name, String author, String genre, String publisher, int year, String summary, boolean wantToRead, double rate, String personalNotes, boolean readAgain);

	
}
