package com.onlinebookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Books")
@Data
public class Book {
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
 	private String bookId;
   	private String bookName;
   	private String authorName;
   	private String summary;
   	private int price;
   	private String category;
}