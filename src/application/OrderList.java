
package application;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.UUID;

public class OrderList
{
	public static LinkedList<Order> order_list;

	public OrderList()
	{
		order_list = new LinkedList<>();
	}

	public OrderList(int test)
	{
		order_list = new LinkedList<>();

		LinkedList<Product> productList = new LinkedList<>();
		productList.add(new Product(new Item("test 1", 1.99, "15h7l"), 6, 3, "supplier 1"));
		productList.add(new Product(new Item("test 2", 2.99, "25h7l"), 10, 4, "supplier 2"));
		productList.add(new Product(new Item("test 3", 3.99, "35h7l"), 7, 1, "supplier 2"));

		order_list.add(new Order(productList,
				                 java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()),
				                 UUID.randomUUID().toString().replace("-", "").substring(0, 10)));

		productList = new LinkedList<>();
		productList.add(new Product(new Item("test 1", 1.99, "15h7l"), 6, 3, "supplier 2"));
		productList.add(new Product(new Item("test 4", 4.99, "45h7l"), 10, 4, "supplier 3"));
		productList.add(new Product(new Item("test 5", 5.99, "55h7l"), 7, 1, "supplier 3"));

		order_list.add(new Order(productList,
                java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()),
                UUID.randomUUID().toString().replace("-", "").substring(0, 10)));

		productList = new LinkedList<>();
		productList.add(new Product(new Item("test 1", 1.99, "15h7l"), 6, 3, "supplier 1"));
		productList.add(new Product(new Item("test 7", 7.99, "75h7l"), 10, 4, "supplier 4"));
		productList.add(new Product(new Item("test 8", 8.99, "85h7l"), 7, 1, "supplier 4"));

		order_list.add(new Order(productList,
                java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()),
                UUID.randomUUID().toString().replace("-", "").substring(0, 10)));
	}

	public void addtoList(Order order)
	{
		order_list.add(order);
	}

	public void removefromList(Order order)
	{
		order_list.remove(order);
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
