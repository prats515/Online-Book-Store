package com.onlinebookstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "Customer")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int customerId;

	@Column(name = "first_Name", nullable = false, length = 100)
	private String firstName;

	@Column(name = "last_Name", nullable = false, length = 100)
	private String lastName;

	private String mobNumber;

	private String email;

	private String password;

	@OneToMany(mappedBy = "c_id", cascade = CascadeType.ALL)
	private java.util.List<Address> adress;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_FK")
	private java.util.List<Order> orders;

}
