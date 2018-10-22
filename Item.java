
public class Item {

	private String id;
	private double price;
	private String supplier;
	private int quantity ;
	private int threshold ;
	
	Item(){}
	
	Item(String id , double price, String supplier , int quantity , int threshold){
		this.id = id ; 
		this.price = price ;
		this.supplier = supplier ;
		this.quantity = quantity ;
		this.threshold = threshold ;
	}
	
	public String getId() {
		return id ;
	}
	
	public double getPrice() {
		return price ;
	}
	
	public String getSupplier() {
		return supplier ;
	}
	
	public int getQuantity() {
		return quantity ;	
	}
	
	public int getThreshold() {
		return threshold ;	
	}
	
	public void setThreshold(int item_threshold) {
		this.threshold = item_threshold ;
	}
	
	public void setQuantity(int item_qty) {
		this.quantity = item_qty;
	}
	
}	