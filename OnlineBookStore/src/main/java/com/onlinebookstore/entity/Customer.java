package com.onlinebookstore.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Collection;
import java.util.List;

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
	private List<Address> adress;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_FK")
	private List<Order> orders;

	/*@OneToMany(targetEntity = Cart.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id")
	private List<Cart> cart;*/

	public Customer() {

	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

}
