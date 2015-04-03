package edu.cs157b.hibernate;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Service Layer for RESTful service
 * @author Justin Tieu
 *
 */
public class OrderEntryService {
	private Hw2DAO oed;
	
	public OrderEntryService() {
		this.oed = new ConcreteHw2DAO();
	}
	
	/**
	 * Creates dummy data
	 */
	public void run() {
		Customer customer = new Customer();
		customer.setName("Bob");
		
		Product p1 = new Product();
		p1.setName("Item 1");
		p1.setPrice(10.00);
		
		Product p2 = new Product();
		p2.setName("Item 2");
		p2.setPrice(10.00);
		
		CustomerOrder order = new CustomerOrder();
		order.setCustomer(customer);
		order.purchaseProduct(p1);
		order.purchaseProduct(p2);
		
		double total = 0;
		for(Product p: order.getProducts()) {
			total += p.getPrice();
		}
		order.setTotal(total);
		
		customer.setOrder(order);
		p1.setOrder(order);
		p2.setOrder(order);
		
		oed.create(customer);
		oed.create(p1);
		oed.create(p2);
		oed.create(order);
	}
	
//	CREATE
	public String submitOrder(int customer_id, String productString) {
		String result = "Creating order for ";
		double total = 0;
		
		List<Product> products = new ArrayList<Product>();
		Customer customer = oed.findCustomerById(customer_id);
		CustomerOrder order = new CustomerOrder();
		result += customer.getName() + ", Products: [";
		
		String[] findProducts = productString.split(",");
		for(int i = 0; i < findProducts.length; i++) {
			Product product = oed.findProductById(Integer.parseInt(findProducts[i]));
			product.setOrder(order);
			products.add(product);
			result += product.getName();
			
			if(i < findProducts.length-1) {
				result += ",";
			}
		}
		
		//find total
		for(Product p: products) {
			total += p.getPrice();
		}
		result += "], Total: " + total;
		
		customer.setOrder(order);
		order.setCustomer(customer);
		order.setProducts(products);
		order.setTotal(total);
		
		oed.create(order);
		
		return result;
	}
	
	public void createCustomer(String name) {
		Customer customer = new Customer();
		customer.setName(name);
		oed.create(customer);
	}
	
	public void createProduct(String name, double price) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		oed.create(product);
	}
	
//	RETRIEVE
	public String getAllOrders() {
		List<CustomerOrder> orders = oed.findAllOrders();
		String result = "";
		for(CustomerOrder o: orders) {
			result += o.toString() + " \n";
		}
		
		return result;
	}
	
	public CustomerOrder getOrder(int id) {
		return oed.findOrderById(id);
	}
	
	public String getAllProducts() {
		List<Product> products = oed.findAllProducts();
		String result = "";
		for(Product p: products) {
			result += p.toString() + " \n";
		}
		
		return result;
	}
	
	public String getAllCustomers() {
		List<Customer> customers = oed.findAllCustomers();
		String result = "";
		for(Customer c: customers) {
			result += c.toString() + " \n";
		}
		
		return result;
	}
	
//	UPDATE
	public void updateOrder(CustomerOrder order) {
		oed.update(order);
	}
	
	public void updateProduct(int id, double price) {
		Product product = oed.findProductById(id);
		product.setPrice(price);
		oed.update(product);
	}
	
//	DELETE
	public void deleteOrder(int id) {
		oed.delete(oed.findOrderById(id));
	}
}
