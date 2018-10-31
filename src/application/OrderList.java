
package application;

import java.util.LinkedList;
import java.util.ListIterator;

public class OrderList
{
	public LinkedList<Order> order_list;

	public OrderList()
	{
		order_list = new LinkedList<>();
	}

	public OrderList(int test)
	{
		order_list = new LinkedList<>();

		makeDummyData();
	}

	public void makeDummyData()
	{
		LinkedList<Product> productList = new LinkedList<>();
		productList.add(new Product(new Item("Banana", 0.99, "4011"), 10, -1, "Super Valu"));
		productList.add(new Product(new Item("Apple", 1.49, "3294"), 10, -1, "Super Valu"));
		productList.add(new Product(new Item("Bell Pepper", 0.99, "4088"), 10, -1, "Super Valu"));

		order_list.add(new Order(productList));

		productList = new LinkedList<>();
		productList.add(new Product(new Item("Shirt", 17.99, "bc7ys99k"), 5, 0, "Clothes R Us"));
		productList.add(new Product(new Item("Jeans", 25.99, "levi8662"), 3, 0, "Clothes R Us"));
		productList.add(new Product(new Item("Hat", 9.99, "cap1b73"),     9, 5, "Lid Place"));

		order_list.add(new Order(productList));

		productList = new LinkedList<>();
		productList.add(new Product(new Item("Hammer", 10.99, "15h7l"), 4, 2, "Winner Tools"));
		productList.add(new Product(new Item("Hack Saw", 18.99, "sdg89"), 3, 1, "Winner Tools"));
		productList.add(new Product(new Item("Plywood", 20.99, "oi87s"), 75, 15, "Good Wood"));
		productList.add(new Product(new Item("Door Frame", 74.99, "sfb98sn"), 3, 0, "Good Wood"));

		Order tempOrder = new Order(productList);
		tempOrder.setDateCreated("Jun 08 2017 12:57:35 PM");

		order_list.add(tempOrder);

		writeFile();
	}

	public void addtoList(Order order)
	{
		order_list.add(order);
	}

	public void removefromList(Order order)
	{
		order_list.remove(order);
	}

	public void writeFile()
	{

	}

	public void readFile()
	{

	}

	@Override
	public String toString()
	{

		String OrderList = "";
		ListIterator<Order> listIterator = order_list.listIterator();
		while (listIterator.hasNext())
		{
			OrderList += "\n" + listIterator.next();
		}
		return "Order List:" + OrderList;
	}
}
