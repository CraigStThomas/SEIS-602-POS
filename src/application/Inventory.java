
package application;

import java.util.LinkedList;
import java.util.ListIterator;

public class Inventory
{
	public static LinkedList<Product> prod_list;

	public Inventory()
	{
		prod_list = new LinkedList<Product>();
	}

	public Inventory(int test)
	{
		prod_list = new LinkedList<Product>();
		Product testProduct1 = new Product(new Item("thing 1", 12.99, "23l5u"), 7, 3, "supplier 1");
		prod_list.add(testProduct1);
		Product testProduct2 = new Product(new Item("thing 2", 7.99, "asfh8"), 7, 4, "supplier 1");
		prod_list.add(testProduct2);
		Product testProduct3 = new Product(new Item("thing 3", 4.99, "s8sd2"), 7, 5, "supplier 1");
		prod_list.add(testProduct3);
	}

	public static void addProduct(Product prod)
	{
		if (prod.getThreshold() < 0)
		{
			prod.setThreshold(0);
		}
		prod_list.add(prod);
	}

	public static void removeProduct(Product prod)
	{
		prod_list.remove(prod);
	}

	public static void buyItem(Item item)
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

	public static void sellItem(Item item)
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
					OrderList.order_list.add(new Order(tempProductList));
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
