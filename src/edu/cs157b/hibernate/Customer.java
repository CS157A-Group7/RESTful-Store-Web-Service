package edu.cs157b.hibernate;

import javax.persistence.*;

/**
 * Implementation of Customer for RESTful Web Services
 * Programmming Assignment #2 - CS157B
 * Instructor: Dr.Kim 
 * 
 * accessors
 * - int getId()
 * - String getName()
 * - Order getOrder()
 * 
 * mutators
 * - setId(int id)
 * - setName(String name)
 * - setOrder(Order order)
 * 
 * @author Justin Tieu
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Customer.findAll", query = "from Customer"),
	@NamedQuery(name = "Customer.findById", query = "from Customer where id = :id"),
	@NamedQuery(name = "Customer.findByName", query = "from Customer where name = :name"),
})
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Transient
	@OneToOne
	private CustomerOrder order;
	
	/**
	 * Gets customer's id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get customer's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get customer's orders
	 * @return
	 */
	public CustomerOrder getOrder() {
		return order;
	}
	
	/**
	 * Update customer's id
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Set customer's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set customer's orders
	 */
	public void setOrder(CustomerOrder order) {
		this.order = order;
	}
	
	/**
	 * Customer info
	 */
	public String toString() {
		return "Id: " + getId() + ", Name: " + getName();
	}
}
