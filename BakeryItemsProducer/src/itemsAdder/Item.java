package itemsAdder;

public class Item {
	private String itemID;
	private String itemName;
	private String itemCategory;
	private String itemPrice;
	private String itemQty;
	
	
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
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
	
		
	/**
	 * @return the itemQty
	 */
	public String getItemQty() {
		return itemQty;
	}
	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	public Item(String itemName, String itemCategory, String itemPrice, String itemQty) {
		super();
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.itemQty = itemQty;
	}
	public Item() {
		
	}
	
}
