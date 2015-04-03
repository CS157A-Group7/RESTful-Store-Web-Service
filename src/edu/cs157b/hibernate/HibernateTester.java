package edu.cs157b.hibernate;

public class HibernateTester {
	public static void main(String[] args) {
		ConcreteHw2DAO d = new ConcreteHw2DAO();
		
//		Customer customer = new Customer();
//		customer.setName("Anthony Tsang");
//		
//		Product p1 = new Product();
//		p1.setName("Item 1");
//		p1.setPrice(10.00);
//		
//		Product p2 = new Product();
//		p2.setName("Item 2");
//		p2.setPrice(10.00);
//		
//		CustomerOrder order = new CustomerOrder();
//		order.setCustomer(customer);
//		order.purchaseProduct(p1);
//		order.purchaseProduct(p2);
//		
//		double total = 0;
//		for(Product p: order.getProducts()) {
//			total += p.getPrice();
//		}
//		order.setTotal(total);
//		
//		customer.setOrder(order);
//		p1.setOrder(order);
//		p2.setOrder(order);
//		
//		d.create(customer);
//		d.create(p1);
//		d.create(p2);
//		d.create(order);
		
		d.closeSessionFactory();
		
	}
}
