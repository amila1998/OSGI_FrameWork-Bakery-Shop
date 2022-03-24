package bakeryitemsproducer;

public interface BakeryItemsProducer {
	//Customer
	public void itemcustomerwellcome();
	public void searchItemByCategory(String category);
	public void searchItemByID(String id);
	public boolean isEmptyCategoryMsg();
	public boolean invalidIDMsg();
	public boolean checkQty(String icID,String icQty);
	public void addToBill(String CName, String iID, String iQty);
	public void showMyBill();
	
	
	//Admin
	public void addBItems(String itemID,String itemName,String itemCategory,String itemPrice,String itemQty);
	public boolean itemSaveSucc();
}
