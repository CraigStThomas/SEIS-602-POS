
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

public class Inventory implements Serializable
{
	private static final long serialVersionUID = 111L;	//serializable wants this
	OrderList orderList;

	public LinkedList<Product> prod_list;

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
		Product testProduct1 = new Product(new Item("thing 1", 12.99, "23l5u"), 7, 3, "supplier 1");
		prod_list.add(testProduct1);
		Product testProduct2 = new Product(new Item("thing 2", 7.99, "asfh8"), 7, 4, "supplier 1");
		prod_list.add(testProduct2);
		Product testProduct3 = new Product(new Item("thing 3", 4.99, "s8sd2"), 7, 5, "supplier 1");
		prod_list.add(testProduct3);
	}

	public void writeFile()
	{
		try
		{
			FileOutputStream f = new FileOutputStream(new File("POS_Inventory.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(this);

			o.close();
			f.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("Error initializing stream");
		}
	}

	public Inventory readFile()
	{
		Inventory tempInventory = new Inventory();

		try
		{
			FileInputStream fi = new FileInputStream(new File("POS_Inventory.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			tempInventory = (Inventory) oi.readObject();

			oi.close();
			fi.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("Error initializing stream");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempInventory;
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
					tempProductList.add(new Product(product.getItem(), 10, 0, product.getSupplier()));
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
