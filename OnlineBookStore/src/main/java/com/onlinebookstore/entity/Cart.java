package com.onlinebookstore.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user;
    private String bookId;
    private String bookName;
    private int price;
    private int quantity;
}
