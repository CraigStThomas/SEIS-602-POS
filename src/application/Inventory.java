package application;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import sun.awt.image.ImageWatched.Link;

public class Inventory
{
	public static LinkedHashMap<Item, Integer> item;

	public Inventory()
	{
		item = new LinkedHashMap<>();

		item.put(new Item("83nf8", 1.95,  "banana"), 10);
		item.put(new Item("asbp9", 22.15, "pretzels"), 10);
		item.put(new Item("e8hen", 12.05, "potato"), 10);
		item.put(new Item("sd0v8", 7.35,  "shirt"), 10);
		item.put(new Item("sav8h", 2.77,  "crayons"), 10);

	}
}
