package com.onlinebookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.Customer;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	@Query("SELECT u FROM Book u WHERE u.bookId = :bookId")
	Book getById(@Param("bookId") String bookId);
}
