package edu.cs157b.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Implementation of Hw2DAO for CRUD operations
 * @author Justin Tieu
 *
 */
public class ConcreteHw2DAO implements Hw2DAO {
	private SessionFactory sessionFactory;
	private Session session;
	
	public ConcreteHw2DAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
	}	
	
	/**
	 * Closes sessions
	 */
	public void closeSessionFactory() {
		this.session.close();
		this.sessionFactory.close();
	}

//	CREATE OPERATIONS
	@Override
	public Customer create(Customer customer) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		return product;
	}

	@Override
	public CustomerOrder create(CustomerOrder order) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		return order;
	}

//	RETRIEVE OPERATIONS
	@Override
	public Customer findCustomerById(int id) {
		Query query = session.getNamedQuery("Customer.findById");
		query.setInteger("id", id);
		return (Customer) query.list().get(0);
	}

	@Override
	public Customer findCustomerByName(String name) {
		Query query = session.getNamedQuery("Customer.findByName");
		query.setString("name", name);
		return (Customer) query.list().get(0);
	}
	
	@Override
	public List<Customer> findAllCustomers() {
		Query query = session.getNamedQuery("Customer.findAll");
		return query.list();
	}

	@Override
	public Product findProductById(int id) {
		Query query = session.getNamedQuery("Product.findById");
		query.setInteger("id", id);
		return (Product) query.list().get(0);
	}

	@Override
	public Product findProductByName(String name) {
		Query query = session.getNamedQuery("Product.findByName");
		query.setString("name", name);
		return (Product) query.list().get(0);
	}

	@Override
	public List<Product> findProductByPrice(double price) {
		Query query = session.getNamedQuery("Product.findByPrice");
		query.setDouble("price", price);
		return query.list();
	}
	
	@Override
	public List<Product> findAllProducts() {
		Query query = session.getNamedQuery("Product.findAll");
		return query.list();
	}

	@Override
	public CustomerOrder findOrderById(int id) {
		Query query = session.getNamedQuery("CustomerOrder.findById");
		query.setInteger("id", id);
		return (CustomerOrder) query.list().get(0);
	}

	@Override
	public CustomerOrder findOrderByTotal(double total) {
		Query query = session.getNamedQuery("CustomerOrder.findByTotal");
		query.setDouble("total", total);
		return (CustomerOrder) query.list().get(0);
	}
	
	@Override
	public List<CustomerOrder> findAllOrders() {
		Query query = session.getNamedQuery("CustomerOrder.findAll");
		return query.list();
	}

//	UPDATE OPERATIONS
	@Override
	public boolean update(Customer customer) {
		session.beginTransaction();
		session.update(customer);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean update(Product product) {
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean update(CustomerOrder order) {
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		return true;
	}

//	DELETE OPERATIONS
	@Override
	public boolean delete(Customer customer) {
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean delete(Product product) {
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean delete(CustomerOrder order) {
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();
		return true;
	}
}
