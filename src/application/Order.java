package application;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Date;

public class Order
{
	private LinkedList<Product>	productList;
	private String				date;
	private String				id;
	private boolean				orderReceived;

	public Order()
	{
		productList = new LinkedList<>();
		orderReceived = false;
	}

	public Order(LinkedList<Product> inputProductList, String inputDate, String inputID)
	{
		productList = inputProductList;
		date = inputDate;
		id = inputID;
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

	public String getDate()
	{
		return date;
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

		return " Order created on: " + date.toString() + ", Order Id: " + this.id + order_content;

	}
}
