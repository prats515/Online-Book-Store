package com.onlinebookstore.payloads;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="BookDto")
public class BookDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int price;
	private Integer orderId;
	private String bookName;
	
}
