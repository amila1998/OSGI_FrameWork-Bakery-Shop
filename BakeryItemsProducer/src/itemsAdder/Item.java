package itemsAdder;

public class Item {
	private String itemName;
	private String itemCategory;
	private String itemPrice;
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}
	/**
	 * @param itemCategory the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	/**
	 * @return the itemPrice
	 */
	public String getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Item(String itemName, String itemCategory, String itemPrice) {
		super();
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
	}
	public Item() {
		
	}
	
}
