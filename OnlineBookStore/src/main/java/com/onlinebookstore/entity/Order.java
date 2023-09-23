package com.onlinebookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onlinebookstore.payloads.BookDto;

import lombok.Data;

@Entity
@Data
@Table(name ="Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy = "orderId")
	private List<BookDto> books;
	
//	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
//	private Customer customer;
}
