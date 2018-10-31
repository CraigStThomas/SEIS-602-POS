package application;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.UUID;

public class Order
{
	private LinkedList<Product>	productList;
	private String				dateCreated;
	private String				dateReceived;
	private String				id;
	private boolean				orderReceived;

	public Order()
	{
		productList = new LinkedList<>();
		dateCreated = DateAndTime.getDateAndTime();
		dateReceived = new String();
		id = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
		orderReceived = false;
	}

	public Order(LinkedList<Product> inputProductList)
	{
		productList = inputProductList;
		dateCreated = DateAndTime.getDateAndTime();
		dateReceived = new String();
		id = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
		orderReceived = false;
	}

	public boolean getOrderReceived()
	{
		return orderReceived;
	}

	public void setOrderReceived(boolean value)
	{
		orderReceived = value;
	}

	public String getId()
	{
		return this.id;
	}

	public String getDateCreated()
	{
		return dateCreated;
	}

	public String getDateReceived()
	{
		return dateReceived;
	}

	public void setDateCreated(String inputDateCreated)
	{
		dateCreated = inputDateCreated;
	}

	public void setDateReceived(String inputDateReceived)
	{
		dateReceived = inputDateReceived;
	}

	public LinkedList<Product> getProductList()
	{
		return productList;
	}

	public void addProduct(Product prod)
	{
		productList.add(prod);
	}

	public void removeOrder(Product prod)
	{
		productList.remove(prod);
	}

	@Override
	public String toString()
	{

		ListIterator<Product> listIterator = productList.listIterator();
		String order_content = "";
		while (listIterator.hasNext())
		{
			order_content += "\n" + listIterator.next();
		}

		return " Order created on: " + dateCreated.toString() + ", Order Id: " + this.id + order_content;

	}
}
