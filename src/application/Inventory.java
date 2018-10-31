
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Inventory
{
	OrderList					orderList;

	public LinkedList<Product>	prod_list;

	public Inventory()
	{
		prod_list = new LinkedList<>();
	}

	public Inventory(OrderList inputOrderList)
	{
		prod_list = new LinkedList<Product>();
		orderList = inputOrderList;
	}

	public Inventory(int test, OrderList inputOrderList)
	{
		orderList = inputOrderList;

		prod_list = new LinkedList<Product>();
		makeDummyData();
	}

	private void makeDummyData()
	{
		Product bananaProduct = new Product(new Item("Banana", 0.99, "4011"), 5, 3, "Super Valu");
		prod_list.add(bananaProduct);
		Product appleProduct = new Product(new Item("Apple", 1.49, "3294"), 9, 4, "Super Valu");
		prod_list.add(appleProduct);
		Product pepperProduct = new Product(new Item("Bell Pepper", 0.99, "4088"), 5, 5, "Super Valu");
		prod_list.add(pepperProduct);
	}

	public void writeFile()
	{
		final String filepath = "Reports";
		final String filename = "Inventory.csv";
		final String tempfilename = "temp.txt";

		try
		{
			File dir = new File(filepath);
			if (dir.exists() == false)
			{
				dir.mkdir();
			}

			File file = new File(filepath + "\\" + filename);
			File tempfile = new File(filepath + "\\" + tempfilename);
			file.createNewFile();
			PrintWriter output = new PrintWriter(filepath + "\\" + tempfilename);
//			Scanner input = new Scanner(filepath + "\\" + filename);
			for (Product prod : prod_list)
			{
				output.println(prod.getItem().getName() + "," +
							   prod.getItem().getPrice() + "," +
							   prod.getItem().getId() + "," +
							   Integer.toString(prod.getQty()) + "," +
							   Integer.toString(prod.getThreshold()) + "," +
							   prod.getSupplier());

			}
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
		final String filename = "Inventory.csv";

		File file = new File(filepath + "\\" + filename);

		String data;
		String[] values;
		try
		{
			Scanner input = new Scanner(file);
			while (input.hasNext())
			{
				data = input.nextLine();
				values = data.split(",");

				Product product = new Product(new Item(values[0], Double.parseDouble(values[1]), values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]), values[5]);
				prod_list.add(product);

			}

			input.close();

		}
		catch (FileNotFoundException e)
		{
			makeDummyData();
		}
	}

	public void addProduct(Product prod)
	{
		if (prod.getThreshold() < 0)
		{
			prod.setThreshold(0);
		}
		prod_list.add(prod);
	}

	public void removeProduct(Product prod)
	{
		prod_list.remove(prod);
	}

	public void buyItem(Item item)
	{ // when customer returns a product//
		for (Product product : prod_list)
		{
			if (product.getItem().equals(item))
			{
				product.setQty(product.getQty() + 1);
				break;
			}
		}
	}

	public void sellItem(Item item)
	{ // when customer buys a product//
		for (Product product : prod_list)
		{
			if ((product.getItem() == item) && (product.getQty() > 0))
			{
				product.setQty(product.getQty() - 1);

				if (product.getQty() < product.getThreshold())
				{
					LinkedList<Product> tempProductList = new LinkedList<>();
					tempProductList.add(new Product(product.getItem(), 10, -1, product.getSupplier()));
					orderList.order_list.add(new Order(tempProductList));
				}
			}
		}
	}

	@Override

	public String toString()
	{
		String inventory = "Inventory: \n";
		ListIterator<Product> listIterator = prod_list.listIterator();
		while (listIterator.hasNext())
		{
			inventory += listIterator.next() + "\n";
		}
		return inventory;
	}
}
