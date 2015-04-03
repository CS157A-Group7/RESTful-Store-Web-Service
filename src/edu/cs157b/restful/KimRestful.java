package edu.cs157b.restful;
import edu.cs157b.hibernate.OrderEntryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class KimRestful {
	private OrderEntryService oes;
	public KimRestful() {
		this.oes = new OrderEntryService();
	}
	
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String getAPI() {
		return "Welcome to the Kim Restful API";
	}
	
	/*
	 * GET HTTP METHODS
	 * /orders
	 * /orders/id
	 * /products
	 * /customers
	 */
	@Path("/orders")
    @GET
	@Produces (MediaType.TEXT_PLAIN)
	public String getAllOrders()
	{
		return oes.getAllOrders();
	}
	
	@Path("/orders/{id}")
    @GET
	@Produces (MediaType.TEXT_PLAIN)
	public String getOrderById(@PathParam("id") int id)
	{
		return oes.getOrder(id).toString();
	}
	
	@Path("/products")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String getAllProducts()
	{
		return oes.getAllProducts();
	}
	
	@Path("/customers")
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String getAllCustomers()
	{
		return oes.getAllCustomers();
	}
	
	/*
	 * POST HTTP METHODS
	 * /customers
	 * /products
	 * /order
	 */
	@Path("/customers/{name}")
	@POST
	@Produces (MediaType.TEXT_PLAIN)
	public String addCustomer(@PathParam("name") String name)
	{
		oes.createCustomer(name);
		return "Creating new customer: " + name;
	}
	
	@Path("/products/{name}/{price}")
	@POST
	@Produces (MediaType.TEXT_PLAIN)
	public String addProduct(@PathParam("name") String name, @PathParam("price") double price)
	{
		oes.createProduct(name, price);
		return "Creating new product: " + name + " sold at $" + price;
	}
	
	@Path("/orders/{customer_id}/{products}")
	@POST
	@Produces (MediaType.TEXT_PLAIN)
	public String addOrder(@PathParam("customer_id") int customer_id, @PathParam("products") String products)
	{
		return oes.submitOrder(customer_id, products);
	}
	
	/*
	 * PUT HTTP METHODS
	 */
	@Path("/products/{id}/{price}")
	@PUT
	@Produces (MediaType.TEXT_PLAIN)
	public String updateProduct(@PathParam("id") int id, @PathParam("price") double price) {
		oes.updateProduct(id, price);
		return "Updating product #" + id + " price to " + price; 
	}
	
	/*
	 * DELETE HTTP METHODS
	 */
	@Path("/orders/{id}")
    @DELETE
	@Produces (MediaType.TEXT_PLAIN)
	public String deleteOrder(@PathParam("id") int id)
	{
		oes.deleteOrder(id);
		return "Deleting Order #" + id;
	}
}
