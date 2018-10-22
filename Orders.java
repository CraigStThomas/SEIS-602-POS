import java.util.ArrayList;
import java.util.Date;


public class Orders {
	public static ArrayList<Orders> mylist= new ArrayList<>();
	private String item_id ;
	private int item_qty ;
	private String supplier ;
	private Date date_created ;
	
	Orders(String item_id , int item_qty , String supplier){
		date_created = new java.util.Date() ;
		this.item_id = item_id ;
		this.item_qty = item_qty ;
		this.supplier = supplier ;
	}
	
	public Date getDate() {
		return date_created ;
	}
	
	public static void save(Orders order) {
		mylist.add(order);
	}
	
}
