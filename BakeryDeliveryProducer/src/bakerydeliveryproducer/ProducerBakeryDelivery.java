package bakerydeliveryproducer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ProducerBakeryDelivery implements BakeryDeliveryProducer{
	public boolean Lsucc =false;
	public String name;
	String Fpath = System.getProperty("user.dir");
	
	public boolean isLsucc() {
		return Lsucc;
	}

	public void setLsucc(boolean lsucc) {
		Lsucc = lsucc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void Dlogin(String cuname, String cpass) {
		boolean found = false;
		
		try {
			
			File myObj = new File(Fpath+"\\driver.txt");  
			if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		        System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String runame;
		              String rpass;
		              String rname;
		              String rtell;
		              
		             
		  
		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj, "rw");
		           
		    		   
		    		   
		 
		            
		            while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                rname = lineSplit[0];
		                rtell = lineSplit[1];
		                runame = lineSplit[2];
		                rpass = lineSplit[3];
		                
		                
		                if (runame.equals(cuname) 
		                    && rpass.equals(cpass)) {
		                    found = true;
		                    this.setName(rname);
		            		System.out.println("Hi " + rname +", ");
		            		this.setLsucc(true);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		            	System.out.println("There is no any Account");
		            	this.setLsucc(false);
		 
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
	public String wellcome() {
		// TODO Auto-generated method stub
		return "_________________________________ Bakery Delivery DashBoard _________________________________";
	}

	@Override
	public boolean loggingSucc() {
		// TODO Auto-generated method stub
		return this.isLsucc();
	}

	@Override
	public void showList() {
		/**boolean found = false;
		
		try {
			
			File myObj2 = new File(Fpath+"\\ItemsList.txt");  
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
		              String DStat;
		             
		              RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");
        
		              System.out.println("|---------------------------------|");
		              System.out.println("|-------- Delivary -----------|");
		              System.out.println("|---------------------------------|");
		              System.out.println("| \tID\t|\tName\t|\tPrice\t|\tQty |");
		              
		              while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		          	 
		              iiID = lineSplit[0];
		              iiQty = lineSplit[1];
		              iTPrice = lineSplit[2];
		              
		                	

		                
		                
		                if ( DStat.equals("YES")) {
		                    found = true;
		                    System.out.println("|---------------------------------|");
		            		System.out.println("| "+ iiID+"\t|\t"+iiQty+"\t|\t"+iPrice+"\t|\t"+iQty+" |");
		            		
		                    continue;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		            	System.out.println("|---------------------------------|");
	            		System.out.println("| There is no Items no delivery Pakages !!"+" |");
		            	
	            		
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
**/
		
	}

}
