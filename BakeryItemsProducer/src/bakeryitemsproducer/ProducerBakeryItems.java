package bakeryitemsproducer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import itemsAdder.Item;

public class ProducerBakeryItems implements BakeryItemsProducer{
	boolean itemSaveSuccMsg , isEmptyCategory, invalidID;
	String BillName = "demo";
	
	
	
	public String getBillName() {
		return BillName;
	}

	public void setBillName(String billName) {
		BillName = billName;
	}

	public boolean isInvalidID() {
		return invalidID;
	}

	public void setInvalidID(boolean invalidID) {
		this.invalidID = invalidID;
	}

	public boolean isEmptyCategory() {
		return isEmptyCategory;
	}

	public void setEmptyCategory(boolean isEmptyCategory) {
		this.isEmptyCategory = isEmptyCategory;
	}

	Scanner input = new Scanner(System.in);
	Item item = new Item();
	
	
	

	public boolean isItemSaveSuccMsg() {
		return itemSaveSuccMsg;
	}

	public void setItemSaveSuccMsg(boolean itemSaveSuccMsg) {
		this.itemSaveSuccMsg = itemSaveSuccMsg;
	}

	@Override
	public void itemcustomerwellcome() {
		System.out.println("_________________________________ Bakery Items _________________________________\n\n"
				+ "1) Bars\n"
				+ "2) Breads\n"
				+ "3) Breakfast Products\n"
				+ "4) Cookies\n"
				+ "5) Desserts\n");
		
	}

	@Override
	public void addBItems(String itemID,String itemName, String itemCategory, String itemPrice, String itemQty) {
		item.setItemID(itemID);
		item.setItemName(itemName);
		item.setItemCategory(itemCategory);
		item.setItemPrice(itemPrice);
		item.setItemQty(itemQty);
		
		this.saveItems();
		
	}
	
	public void saveItems() {
		 boolean found = false;
			
			try {  
			      File myObj2 = new File("C:\\Users\\Devin\\Desktop\\New folder (6)\\ItemsList.txt");  
			      if (myObj2.createNewFile()) {  
			        System.out.println("File created: " + myObj2.getName()); 
			        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
			      } else {
			    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
			      }
			    	  try { 
			    		  String nameNumberString;
			    		  int index;
			    		  String iID;
			              String iName;
			              String iCategory;
			              String iPrice;
			              String iQty;
			              String newiID = item.getItemID();
			              String newiName = item.getItemName();
			              String newiCategory = item.getItemCategory();
			              String newiPrice = item.getItemPrice();
			              String newiQty =  item.getItemQty();

			    		   RandomAccessFile raf
			                = new RandomAccessFile(myObj2, "rw");

			            while (raf.getFilePointer() < raf.length()) {

			                nameNumberString = raf.readLine();

			                String[] lineSplit
			                    = nameNumberString.split("!");
			 
			               iID = lineSplit[0];
				           iName = lineSplit[1];
				           iCategory = lineSplit[2];
				           iPrice = lineSplit[3];
				           iQty = lineSplit[4];

			                if (iID.equals(newiID)
			                    || iName.equals(newiName)) {
			                    found = true;
			                    System.out.println(" Already Inserted!!! ");
			                    this.setItemSaveSuccMsg(false);
			                    break;
			                }
			            }
			 
			            if (found == false) {

			                nameNumberString
			                    = newiID + "!"
			                      + newiName+"!"+newiCategory+"!"+newiPrice+"!"+newiQty;
			 
			               
			                raf.writeBytes(nameNumberString);
			 
			                raf.writeBytes(System.lineSeparator());
			 
			                System.out.println("Successfully Inserted !!! ");
			                
			                this.setItemSaveSuccMsg(true);
			                raf.close();
			            }
 
			    	    } catch (IOException e) {
			    	      System.out.println("An error occurred.");
			    	      e.printStackTrace();
			    	    }  
			      
 
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();  
			    }  

	}

	@Override
	public boolean itemSaveSucc() {
		
		return this.isItemSaveSuccMsg();
	}

	@Override
	public void searchItemByCategory(String category) {
		boolean found = false;
				
				try {
					
					File myObj2 = new File("C:\\Users\\Devin\\Desktop\\New folder (6)\\ItemsList.txt");  
					if (myObj2.createNewFile()) {  
				        System.out.println("File created: " + myObj2.getName());  
				        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
				      } else {
				    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
				      }  
				    	  try { 
				    		  String nameNumberString;
				    		  int index;
				    		  String iID;
				              String iName;
				              String iCategory;
				              String iPrice;
				              String iQty;
				             
				              RandomAccessFile raf
				                = new RandomAccessFile(myObj2, "rw");
		        
				              System.out.println("|---------------------------------|");
				              System.out.println("|-------- "+category+" -----------|");
				              System.out.println("|---------------------------------|");
				              System.out.println("| \tID\t|\tName\t|\tPrice\t|\tQty |");
				              
				              while (raf.getFilePointer() < raf.length()) {
				 
				                
				                nameNumberString = raf.readLine();
				 
				                
				                String[] lineSplit
				                    = nameNumberString.split("!");
				 
				              
				                	iID = lineSplit[0];
				                	iName = lineSplit[1];
				                	iCategory = lineSplit[2];
				                	iPrice = lineSplit[3];
				                	iQty = lineSplit[4];

				                
				                
				                if (iCategory.equals(category)) {
				                    found = true;
				                    System.out.println("|---------------------------------|");
				            		System.out.println("| "+iID+"\t|\t"+iName+"\t|\t"+iPrice+"\t|\t"+iQty+" |");
				            		this.setEmptyCategory(false);
				                    continue;
				                }
				            }
				 
				            if (found == false) {
				 
				              
				            	System.out.println("|---------------------------------|");
			            		System.out.println("| There is no Items in Under the "+category+" category !!"+" |");
				            	
			            		this.setEmptyCategory(true);
				                raf.close();
				            }
				    		  
				    		  
				    	    } catch (IOException e) {
				    	      System.out.println("An error occurred.");
				    	      e.printStackTrace();
				    	    }  
				       
				      
				     
				      
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();  
				    }
		
	}
	
	

	@Override
	public void searchItemByID(String id) {
		boolean found = false;
		
		try {
			
			File myObj2 = new File("C:\\Users\\Devin\\Desktop\\New folder (6)\\ItemsList.txt");  
			if (myObj2.createNewFile()) {  
		        System.out.println("File created: " + myObj2.getName());  
		        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String iID;
		              String iName;
		              String iCategory;
		              String iPrice;
		              String iQty;
		             
		              RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");
        
		              		              
		              while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                	iID = lineSplit[0];
		                	iName = lineSplit[1];
		                	iCategory = lineSplit[2];
		                	iPrice = lineSplit[3];
		                	iQty = lineSplit[4];

		                
		                
		                if (iID.equals(id)) {
		                    found = true;
		                    System.out.println("|---------------------------------|");
		            		System.out.println("| ID: "+iID+"\nName: "+iName+"\nPrice: "+iPrice+"\nQty: "+iQty+" |\n");
		            		this.setInvalidID(false);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		            	System.out.println("|---------------------------------|");
	            		System.out.println("| There is no Items in Under the "+id+" ID !!"+" |");
		            	
	            		this.setInvalidID(true);
		                raf.close();
		            }
		    		  
		    		  
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		       
		      
		     
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
		
	}

	@Override
	public boolean isEmptyCategoryMsg() {
		
		return this.isEmptyCategory();
	}

	@Override
	public boolean invalidIDMsg() {
	
		return this.isInvalidID();
	}

	@Override
	public boolean checkQty(String icID, String icQty) {
		boolean check=false;
		
		boolean found = false;
				
				try {
					
					File myObj2 = new File("C:\\Users\\Devin\\Desktop\\New folder (6)\\ItemsList.txt");  
					if (myObj2.createNewFile()) {  
				        System.out.println("File created: " + myObj2.getName());  
				        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
				      } else {
				    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
				      } 
				    	  try { 
				    		  String nameNumberString;
				    		  int index;
				    		  String iID;
				              String iName;
				              String iCategory;
				              String iPrice;
				              String iQty;
				             
				              RandomAccessFile raf
				                = new RandomAccessFile(myObj2, "rw");
		        
				              		              
				              while (raf.getFilePointer() < raf.length()) {
				 
				                
				                nameNumberString = raf.readLine();
				 
				                
				                String[] lineSplit
				                    = nameNumberString.split("!");
				 
				              
				                	iID = lineSplit[0];
				                	iName = lineSplit[1];
				                	iCategory = lineSplit[2];
				                	iPrice = lineSplit[3];
				                	iQty = lineSplit[4];
		
				                
				                
				                if (iID.equals(icID)) {
				                    found = true;
				                    int pQty=Integer.parseInt(icQty);
				                    int rQty=Integer.parseInt(iQty);
				                    if(rQty>=pQty) {
				                    	check=true;
				                    }
				                    break;
				                }
				            }
				 
				            if (found == false) {
				 
				              
				            	System.out.println("|---------------------------------|");
			            		System.out.println("| There is no Items in Under the "+icID+" ID !!"+" |");
				            	
				                raf.close();
				            }
				    		  
				    		  
				    	    } catch (IOException e) {
				    	      System.out.println("An error occurred.");
				    	      e.printStackTrace();
				    	    }  
				       
		      
		     
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
		
		
		
		return check;
	}

	@Override
	public void addToBill(String CName, String iID, String iQty) {
		/**
		String gNo= Integer.toString(genarateANumber());
		this.setBillName(CName+gNo);
		int p =this.getItemPrice(iID);
		int tot =  p*Integer.parseInt(iQty);
		boolean found = false;
		
		
		try {  
			
		      File myObj2 = new File("C:\\Users\\Devin\\Desktop\\New folder (6)\\"+this.getBillName()+".txt");  
		      if (myObj2.createNewFile()) {  
		        System.out.println("File created: " + myObj2.getName()); 
		        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      }
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String iiID;
		              String iiQty;
		              String iTPrice;
		              String newiID = iID;
		              String newTPrice =Integer.toString(tot);
		              String newiQty =  item.getItemQty();

		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");

		            while (raf.getFilePointer() < raf.length()) {

		                nameNumberString = raf.readLine();

		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		               iiID = lineSplit[0];
		               iiQty = lineSplit[1];
		               iTPrice = lineSplit[2];
			          
		                if (iiID.equals(newiID)
		                    || iName.equals(newiName)) {
		                    found = true;
		                    System.out.println(" Already Inserted!!! ");
		                    this.setItemSaveSuccMsg(false);
		                    break;
		                }
		            }
		 
		            if (found == false) {

		                nameNumberString
		                    = newiID + "!"
		                      + newiName+"!"+newiCategory+"!"+newiPrice+"!"+newiQty;
		 
		               
		                raf.writeBytes(nameNumberString);
		 
		                raf.writeBytes(System.lineSeparator());
		 
		                System.out.println("Successfully Inserted !!! ");
		                
		                this.setItemSaveSuccMsg(true);
		                raf.close();
		            }

		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		      

		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }  

		
		
	}
	
	
	public int genarateANumber() {
		
		int min = 1;
	    int max = 1000000;
	        
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return random_int;
		
	}
	
	public int getItemPrice(String icID) {
		int p=0;
		boolean found = false;
		
		try {
			
			File myObj2 = new File("C:\\Users\\Devin\\Desktop\\New folder (6)\\ItemsList.txt");  
			if (myObj2.createNewFile()) {  
		        System.out.println("File created: " + myObj2.getName());  
		        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String iID;
		              String iName;
		              String iCategory;
		              String iPrice;
		              String iQty;
		             
		              RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");
        
		              		              
		              while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                	iID = lineSplit[0];
		                	iName = lineSplit[1];
		                	iCategory = lineSplit[2];
		                	iPrice = lineSplit[3];
		                	iQty = lineSplit[4];

		                
		                
		                if (iID.equals(icID)) {
		                    found = true;
		                    p=Integer.parseInt(iPrice);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		     	System.out.println("|---------------------------------|");
	            		System.out.println("| There is no Items in Under the "+icID+" ID !!"+" |");
		            	
		                raf.close();
		            }
		            
		    		  
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();  
    }

		return p;
		**/
	}
	



}
