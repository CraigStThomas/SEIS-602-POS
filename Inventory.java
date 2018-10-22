import java.util.ArrayList;

public class Inventory extends Item{

	
	
	private ArrayList<Item> inventory;

	Inventory(ArrayList<Item> inventory){
		
		this.inventory = inventory ;
		
	}
	
	public void printInventory() {
		for (int i = 0 ; i < inventory.size() ; i++) {
		
			System.out.printf("%8s  %5.2f %8s  %5d  %5d \n", inventory.get(i).getId(), inventory.get(i).getPrice() , 
					inventory.get(i).getSupplier() ,inventory.get(i).getQuantity() ,inventory.get(i).getThreshold());
		}
	}

	
		
	public void addQuantity(String item_name , int item_qty) {
		for(int i = 0 ; i < inventory.size() ; i++) {
			if (inventory.get(i).getId() == item_name) {
				int current_qty = inventory.get(i).getQuantity();
				inventory.get(i).setQuantity(current_qty + item_qty);  ;
			}
		}
	}
	
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	public void removeItem(String item_name) {
		for (int i = 0 ; i < inventory.size() ; i++) {
			if(inventory.get(i).getId() == item_name) {
				inventory.remove(i);
			}
		}
	}
	
	public void setThreshold(String item_name , int new_threshold) {
		for (int i = 0 ; i < inventory.size() ; i++) {
			if (inventory.get(i).getId() == item_name) {
				inventory.get(i).setThreshold(new_threshold);

				}
		}
	}
}


