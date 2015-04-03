package edu.cs157b.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Implementation of Order for RESTful Web Services
 * Programmming Assignment #2 - CS157B
 * Instructor: Dr.Kim 
 * 
 * accessors
 * - int getId()
 * - double getTotal()
 * - Customer getCustomer()
 * - List<Product> getProducts()
 * 
 * mutators
 * - setId(int id)
 * - setTotal(double total)
 * - setCustomer(Customer customer)
 * - setProducts(ArrayList<Product> products)
 * - purchaseProduct(Product product)
 * - removeProduct(Product product)
 * 
 * @author Justin Tieu
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "CustomerOrder.findAll", query = "from CustomerOrder"),
	@NamedQuery(name = "CustomerOrder.findById", query = "from CustomerOrder where id = :id"),
	@NamedQuery(name = "CustomerOrder.findByTotal", query = "from CustomerOrder where total = :total"),
})
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="total")
	private double total;
	
	@OneToOne//(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany//(cascade = CascadeType.ALL)
	private List<Product> products;
	
	/**
	 * Creates a new Order object which contains
	 */
	public CustomerOrder() {
		this.products = new ArrayList<Product>();
	}
	
	/**
	 * Gets order object's id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get order's total
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Gets order's customer
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Gets order's products
	 * @return
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Sets order's id
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set order's total
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Sets order's custom
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Sets order's products
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/**
	 * Adds a product to order
	 * @param product
	 */
	public void purchaseProduct(Product product) {
		products.add(product);
	}

	/**
	 * Removes a product from order
	 * @param product
	 */
	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	public String toString() {
		return "Order #" + getId() + " for " + getCustomer().getName() + " - Products: " + products.toString();
	}
}
