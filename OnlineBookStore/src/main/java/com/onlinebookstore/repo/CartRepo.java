package com.onlinebookstore.repo;

import com.onlinebookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    @Query("SELECT u FROM Cart u WHERE u.bookId = :id")
    Cart searchById(String id);
}

