package edu.cs157b.hibernate;

import javax.persistence.*;

/**
 * Implementation of Product for RESTful Web Services
 * Programmming Assignment #2 - CS157B
 * Instructor: Dr.Kim 
 * 
 * accessors
 * - int getId()
 * - String getName()
 * - double getPrice()
 * 
 * mutators
 * - setId(int id)
 * - setName(String name)
 * - setPrice(double price)
 * 
 * @author Justin Tieu
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Product.findAll", query = "from Product"),
	@NamedQuery(name = "Product.findById", query = "from Product where id = :id"),
	@NamedQuery(name = "Product.findByName", query = "from Product WHERE name = :name"),
	@NamedQuery(name = "Product.findByPrice", query = "from Product WHERE price = :price"),
})
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Transient
	@ManyToOne
	private CustomerOrder order;
	
	/**
	 * Gets product's id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get product's name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get product's price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Get order for product
	 * @return order
	 */
	public CustomerOrder getOrder() {
		return order;
	}
	
	/**
	 * Update product's id
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Set product's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set product's price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Set product's order
	 * @param order
	 */
	public void setOrder(CustomerOrder order) {
		this.order = order;
	}
	
	public String toString() {
		return "Id: " + getId() + ", Name: " + getName() + ", Price: " + getPrice();
	}
}
