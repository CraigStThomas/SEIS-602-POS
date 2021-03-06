
package application;

public class Item
{
	private String	name;
	private double	price;
	private String	id;

	public Item(String name, double price, String id)
	{

		this.name = name;
		this.price = price;
		this.id = id;
	}

	public Item copy()
	{
		return new Item(new String(name), price, new String(id));
	}

	public boolean equals(Item item)
	{
		boolean returnValue = false;

		if ((item.id.equals(id)) && (item.name.equals(name)) && (item.price == price))
		{
			returnValue = true;
		}

		return returnValue;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return " Name: " + this.name + ", Price: " + this.price + ", Id: " + this.price;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass() == this.getClass())
		{
			Item inputItem = (Item) obj;

			if (name.equals(inputItem.name) && id.equals(inputItem.id) && (price == inputItem.price))
			{
				return true;
			}
		}

		return false;
	}
}
