
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

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
		final String filepath = "Reports";
		final String filename = "OrderList.csv";
		final String tempfilename = "temp.txt";

		try
		{
			File dir = new File(filepath);
			if (dir.exists() == false)
			{
				dir.mkdir();
			}

			File file = new File(filepath + "\\" + filename);
			file.createNewFile();
			File tempfile = new File(filepath + "\\" + tempfilename);
			PrintWriter output = new PrintWriter(filepath + "\\" + tempfilename);


			output.println("Order ID" + "," +
		               	   "Order Received" + "," +
		               	   "Date Created" + "," +
		               	   "Date Received" + "," +
		               	   "Item Name" + "," +
					   	   "Item Price" + "," +
					   	   "Item ID" + "," +
					   	   "Quantity" + "," +
					   	   "Threshold" + "," +
					   	   "Supplier");

			for (Order order : order_list)
			{
				int index = 0;

//				output.println();

				for (Product product : order.getProductList())
				{
					String orderID = "";
					String orderReceived = "";
					String dateCreated = "";
					String dateReceived = "";

					if (index == 0)
					{
						orderID = order.getId();
						orderReceived = Boolean.toString(order.getOrderReceived());
						dateCreated = order.getDateCreated();
						dateReceived = order.getDateReceived();
					}

					output.println(orderID + "," +
					               orderReceived + "," +
					               dateCreated + "," +
								   dateReceived + "," +
								   product.getItem().getName() + "," +
								   product.getItem().getPrice() + "," +
								   product.getItem().getId() + "," +
					               product.getQty() + "," +
					               product.getThreshold() + "," +
					               product.getSupplier());
					index++;
				}
			}
//			input.close();
			output.close();
			file.delete();
			tempfile.renameTo(file);

		}
		catch (IOException e)
		{

			e.printStackTrace();

		}
	}

	public void readFile()
	{
		final String filepath = "Reports";
		final String filename = "OrderList.csv";

		File file = new File(filepath + "\\" + filename);

		String data;
		String[] values;
		try
		{
			Scanner input = new Scanner(file);

			//burn the header
			if (input.hasNext())
			{
				data = input.nextLine();
			}

			int index = 0;
			Order tempOrder = new Order();

			while (input.hasNextLine())
			{
				data = input.nextLine();
				values = data.split(",");

				if (values[0].equals(""))
				{
					tempOrder.getProductList().add(new Product(new Item(values[4], Double.parseDouble(values[5]), values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), values[9]));
				}
				else
				{
					if (index != 0)
					{
						order_list.add(tempOrder);
					}

					tempOrder = new Order();

					tempOrder.setId(values[0]);
					tempOrder.setOrderReceived(Boolean.parseBoolean(values[1]));
					tempOrder.setDateCreated(values[2]);
					tempOrder.setDateReceived(values[3]);
					tempOrder.getProductList().add(new Product(new Item(values[4], Double.parseDouble(values[5]), values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), values[9]));
				}
				index++;
			}

			order_list.add(tempOrder);

			input.close();

		}
		catch (FileNotFoundException e)
		{
			makeDummyData();
		}
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
