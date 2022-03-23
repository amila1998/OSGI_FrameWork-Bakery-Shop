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
import java.util.Scanner;
import java.util.StringTokenizer;

import customerRegister.Customer;
import mongoDBConn.DBManager;

public class ProducerBakeryCustomer implements BakeryCustomerProducer {
	
	
	
	
	
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
		
		
		
		
	}
	
		

	@Override
	public String display() {
		//this.savetoDB(customer.getcName());
		
			this.AddRecord();
			this.ViewAllRecord();
		
		return customer.getcName() + " " + customer.getcAddress() + " " + customer.getcEmail() + " " + customer.getcPhone() + " ";
	}
	
	
	
	public void AddRecord() {
		/*try {
			oos =new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject("Amila"+" "+"Panadura");
			oos.close();
			System.out.println("Added");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {  
		      File myObj = new File("C:\\Users\\sean udayantha\\Desktop\\New folder\\customer.txt");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		      } else {  
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
		    		  	    		 
		    		  /**FileWriter myWriter = new FileWriter("customer.txt");
		    	      myWriter.write(customer.getcName()+" "+customer.getcEmail());
		    	      
		    	      myWriter.close();
		    	      System.out.println("Successfully wrote to the file.");**/
		    		  
		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj, "rw");
		            boolean found = false;
		 
		            
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
		 
		                raf.close();
		            }
		    		  
		    		  
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		      } 
		      
		     
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }  
		
		
}
	
	public void ViewAllRecord()  {
		try {
		      File myObj = new File("C:\\Users\\sean udayantha\\Desktop\\New folder\\customer.txt");
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
		try {
			
			File myObj = new File("C:\\Users\\sean udayantha\\Desktop\\New folder\\customer.txt");  
			if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		      } else {  
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String rname;
		              String rphone;
		              String raddress;
		              String remail;
		             
		    		  	    		 
		    		  /**FileWriter myWriter = new FileWriter("customer.txt");
		    	      myWriter.write(customer.getcName()+" "+customer.getcEmail());
		    	      
		    	      myWriter.close();
		    	      System.out.println("Successfully wrote to the file.");**/
		    		  
		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj, "rw");
		           
		    		   System.out.println(cname + cphone +", ");
		    		   boolean found = false;
		 
		            
		            while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                rname = lineSplit[0];
		                rphone = lineSplit[1];
		                remail = lineSplit[2];
		                raddress = lineSplit[3];
		                
		                System.out.println(
		                        "Friend Name: " + rname + "\n"
		                        + "Contact Number: " + rphone + "\n\n");
		                
		                if (rname.equals(cname) 
		                    && rphone.equals(cphone)) {
		                    found = true;
		                    customer.setcName(rname);
		            		customer.setcEmail(remail);
		            		customer.setcAddress(raddress);
		            		customer.setcPhone(rphone);
		            		System.out.println("Hi " + rname +", ");
		                    break;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		            	System.out.println("There is no any Account");
		 
		                raf.close();
		            }
		    		  
		    		  
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		      } 
		      
		     
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }  
		
 
		
		
	}	
	
	
	
	
}
