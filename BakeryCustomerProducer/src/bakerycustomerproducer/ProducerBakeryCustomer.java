package bakerycustomerproducer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import customerRegister.Customer;
import mongoDBConn.DBManager;

public class ProducerBakeryCustomer implements BakeryCustomerProducer {
	private boolean lMsg;
	String Fpath = System.getProperty("user.dir");
	
	
	
	HashMap<String, String> billIems = new HashMap<String, String>();
	Scanner input = new Scanner(System.in);
	//Gson gson = new Gson();
	Customer customer = new Customer();
	//DBManager dbManager = new DBManager();
	//File file = new File("customer.txt");
	
	
	
	
	@Override
	public String wellcome() {
		return "_________________________________ Wellcome to the Bakery Shop !! _________________________________";
		
	}


	@Override
	public void insertProducerBakeryCustomer(String name, String address, String email, String phone) {
		
		customer.setcName(name);
		customer.setcEmail(email);
		customer.setcAddress(address);
		customer.setcPhone(phone);
		
		this.AddRecord();
		
		
	}
	
		

	@Override
	public String display() {
		//this.savetoDB(customer.getcName());
		
			
			//this.ViewAllRecord();
		
		return customer.getcName() + " " + customer.getcAddress() + " " + customer.getcEmail() + " " + customer.getcPhone() + " ";
	}
	
	
	
	public void AddRecord() {
		
		 boolean found = false;

		try {  
		      File myObj = new File(Fpath+"\\customer.txt");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		        System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String name;
		              String number;
		              String address;
		              String email;
		              String newName = customer.getcName();     
		              String newNumber = customer.getcPhone();
		              String newEmail = customer.getcEmail();
		              String newAddress = customer.getcAddress();
	
		    		  
		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj, "rw");
		           
		 
		            
		            while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                name = lineSplit[0];
		                number = lineSplit[1];
		                email = lineSplit[2];
		                address = lineSplit[3];
		                
		                if (name.equals(newName)
		                    || number.equals(newNumber)) {
		                    found = true;
		                    System.out.println(" You are already Registered!!! ");
		                    this.setlMsg(false);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		                nameNumberString
		                    = newName + "!"
		                      + newNumber+"!"+newEmail+"!"+newAddress;
		 
		               
		                raf.writeBytes(nameNumberString);
		 
		                raf.writeBytes(System.lineSeparator());
		 
		                System.out.println("Registration Successfull !!! ");
		                System.out.println("Hi " + newName +", ");
		                this.setlMsg(true);
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
	
	public void ViewAllRecord()  {
		try {
		      File myObj = new File(Fpath+"\\customer.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
    		
    }


	@Override
	public void customerLogin(String cname, String cphone) {
		boolean found = false;
		
		try {
			
			File myObj = new File(Fpath+"\\customer.txt");  
			if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		        System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String rname;
		              String rphone;
		              String raddress;
		              String remail;
		             
		  
		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj, "rw");
		           
		    		   
		    		   
		 
		            
		            while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                rname = lineSplit[0];
		                rphone = lineSplit[1];
		                remail = lineSplit[2];
		                raddress = lineSplit[3];
		                
		                
		                if (rname.equals(cname) 
		                    && rphone.equals(cphone)) {
		                    found = true;
		                    customer.setcName(rname);
		            		customer.setcEmail(remail);
		            		customer.setcAddress(raddress);
		            		customer.setcPhone(rphone);
		            		System.out.println("Hi " + rname +", ");
		            		this.setlMsg(true);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		            	System.out.println("There is no any Account");
		            	this.setlMsg(false);
		 
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
	public boolean loggingSucc() {
		return this.islMsg();
		
		
	}
	


	public boolean islMsg() {
		return lMsg;
	}


	public void setlMsg(boolean lMsg) {
		this.lMsg = lMsg;
	}


	@Override
	public String getMyName() {
		
		return customer.getcName();
	}
	
	

	


	
	
	
	
	
}
