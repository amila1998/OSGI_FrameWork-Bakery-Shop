package bakeryadminproducer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import deliveryRegister.deliveyR;

public class ProducerBakeryAdmin implements BakeryAdminProducer {
	Scanner input = new Scanner(System.in);
	deliveyR delivery = new deliveyR();
	@Override
	public String myName() {
		
		return "_________________________________ Bakery Admin DashBoard _________________________________\\n";
	}
	@Override
	public void insertDeliveryPreson(String name, String phone, String userName, String password) {
		// TODO Auto-generated method stub
		delivery.setdName(name);
		delivery.setdPhone(phone);
		delivery.setdUserName(userName);
		delivery.setdPassword(password);

		this.AddRecord();
	}

	private void AddRecord() {
		// TODO Auto-generated method stub
		boolean found = false;
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
		      File myObj = new File("C:\\Users\\sean udayantha\\Desktop\\New folder\\driver.txt");  
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
		              String username;
		              String password;
		              String newName= delivery.getdName();     
		              String newNumber = delivery.getdPhone();
		              String newUserName = delivery.getdUserName();
		              String newPassword = delivery.getdPassword();

		    		  /**FileWriter myWriter = new FileWriter("customer.txt");
		    	      myWriter.write(customer.getcName()+" "+customer.getcEmail());
		    	      
		    	      myWriter.close();
		    	      System.out.println("Successfully wrote to the file.");**/

		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj, "rw");



		            while (raf.getFilePointer() < raf.length()) {


		                nameNumberString = raf.readLine();


		                String[] lineSplit
		                    = nameNumberString.split("!");


		                name = lineSplit[0];
		                number = lineSplit[1];
		                username= lineSplit[2];
		                password = lineSplit[3];

		                if (name.equals(newName)
		                    || number.equals(newNumber)) {
		                    found = true;
		                    System.out.println(" Delivery preson already Registered!!! ");

		                    break;
		                }
		            }

		            if (found == false) {


		                nameNumberString
		                    = newName + "!"
		                      + newNumber+"!"+newUserName+"!"+newPassword;


		                raf.writeBytes(nameNumberString);

		                raf.writeBytes(System.lineSeparator());

		                System.out.println("Registration Successfull !!! ");
		                System.out.println("Hi " + newName +", well come to bakery delivery service ");

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
		      File myObj = new File("C:\\Users\\sean udayantha\\Desktop\\New folder\\driver.txt");
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
	public String DeliveryPresonDisplay() {
		// TODO Auto-generated method stub
		return delivery.getdName() + " " +delivery.getdPhone()+"";
	}


}
