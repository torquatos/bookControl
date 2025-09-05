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
	
}