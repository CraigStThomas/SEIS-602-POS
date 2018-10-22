import java.util.ArrayList;

public class MainMethod {
	public static void main(String[] args) {
		
	Item item1 = new Item("Beer", 9.99 , "Rochester" , 20, 20);
	Item item2 = new Item("TV", 100.50 , "Houston" , 5, 60);	
	Item item3 = new Item("Food", 6.2 , "Minneapolis" , 10, 20);
	
	ArrayList<Item> my_list = new ArrayList<>();
	
	my_list.add(item1);
	my_list.add(item2);
	my_list.add(item3);
	
	Inventory my_inventory = new Inventory(my_list);
	my_inventory.printInventory();
	my_inventory.removeItem("Food");
	System.out.println("");
	my_inventory.printInventory();
	my_inventory.addItem(new Item("Stuff", 2 , "Duluth", 6, 50));
	System.out.println("");
	my_inventory.printInventory();	
	my_inventory.addQuantity("Beer", 2);
	System.out.println("");
	my_inventory.printInventory();
	my_inventory.setThreshold("TV", 20);
	System.out.println("");
	my_inventory.printInventory();
	
	
	}
}