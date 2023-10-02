package com.onlinebookstore.repo;

import com.onlinebookstore.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    @Query("SELECT u FROM Cart u WHERE u.bookId = :id")
    Cart searchById(String id);

    /*@Query("SELECT u FROM Cart u WHERE u.user = :userName")
    Cart findByUsername(String userName);*/

    @Query("SELECT u FROM Cart u WHERE u.user = :username")
    Page<Cart> findByUsername(String username, Pageable pageable);
}

