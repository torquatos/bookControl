package com.torquatos.booksystem.book_management_system.repo;

import com.torquatos.booksystem.book_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
