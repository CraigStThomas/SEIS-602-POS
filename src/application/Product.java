package application;

public class Product {

	private Item item;
	private int qty;
	private int threshold;
	private String supplier;

	Product(Item item , int qty , int threshold , String supplier){
		this.item = item;
		this.qty = qty;
		this.threshold = threshold;
		this.supplier = supplier;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String toString() {
		return " Item: " + item.getName() + ", Quantity: " + this.qty + ", Threshold: " + this.threshold
				+ ", Supplier: " + this.supplier;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj.getClass() == this.getClass())
		{
			Product inputProduct = (Product) obj;

			if (item.equals(inputProduct.item) && supplier.equals(inputProduct.supplier))
			{
				return true;
			}
		}

		return false;
	}
}
