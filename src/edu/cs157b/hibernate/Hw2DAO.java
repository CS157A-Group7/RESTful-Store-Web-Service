package edu.cs157b.hibernate;

import java.util.List;

/**
 * Interface containing methods for CRUD operations 
 * @author Justin Tieu
 *
 */
public interface Hw2DAO {
//	create
	Customer create(Customer customer);
	Product create(Product product);
	CustomerOrder create(CustomerOrder order);
	
//	retrieve
	Customer findCustomerById(int id);
	Customer findCustomerByName(String name);
	List<Customer> findAllCustomers();
	
	Product findProductById(int id);
	Product findProductByName(String name);
	List<Product> findProductByPrice(double price);
	List<Product> findAllProducts();
	
	CustomerOrder findOrderById(int id);
	CustomerOrder findOrderByTotal(double total);
	List<CustomerOrder> findAllOrders();
	
//	update
	boolean update(Customer customer);
	boolean update(Product product);
	boolean update(CustomerOrder order);

//	delete
	boolean delete(Customer customer);
	boolean delete(Product product);
	boolean delete(CustomerOrder order);
}
