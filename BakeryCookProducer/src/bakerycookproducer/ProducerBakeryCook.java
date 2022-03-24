package bakerycookproducer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import bakerycook.CookRecipes;

public class ProducerBakeryCook implements BakeryCookProducer{
	Scanner input = new Scanner(System.in);
	CookRecipes recipes  = new CookRecipes();

	@Override
	public String wellcomeCook() {
		// TODO Auto-generated method stub
		return "_________________________________ Bakery Cook DashBoard _________________________________\\n";
	}

	@Override
	public void insertnewRecipes(String foodItem, String recipesName, String Driscription) {
		// TODO Auto-generated method stub
		recipes.setFoodItem(foodItem);
		recipes.setRecipesName(recipesName);
		recipes.setDriscription(Driscription);
		this.AddRecord();


	}
	private void AddRecord() {
		// TODO Auto-generated method stub
		boolean found = false;

		try {  
			File myObj = new File("C:\\Users\\Hashi\\Desktop\\New folder (6)\\Recipes.txt");  
			if (myObj.createNewFile()) {  
				System.out.println("File created: " + myObj.getName());  
				System.out.println("File Opened: " + myObj.getAbsolutePath()); 
			} else {
				System.out.println("File Opened: " + myObj.getAbsolutePath()); 
			} 
			try { 
				String nameNumberString;
				int index;
				String foodItem;
				String recipesName;
				String Driscription;
				String newfoodItem= recipes.getFoodItem();     
				String newrecipesName = recipes.getRecipesName();
				String newDriscription = recipes.getDriscription();


				/**FileWriter myWriter = new FileWriter("customer.txt");
		    	      myWriter.write(customer.getcName()+" "+customer.getcEmail());
		    	      myWriter.close();
		    	      System.out.println("Successfully wrote to the file.");**/

				RandomAccessFile raf= new RandomAccessFile(myObj, "rw");



//				while (raf.getFilePointer() < raf.length()) {
//
//
//					nameNumberString = raf.readLine();
//
//
//					String[] lineSplit
//					= nameNumberString.split("!");
//
//
//					name = lineSplit[0];
//					number = lineSplit[1];
//					username= lineSplit[2];
//					password = lineSplit[3];
//
//					if (name.equals(newName)
//							|| number.equals(newNumber)) {
//						found = true;
//						System.out.println(" Delivery preson already Registered!!! ");
//
//						break;
//					}
//				}

				if (found == false) {


					nameNumberString= newfoodItem + "!"+ newrecipesName+"!"+newDriscription;


					raf.writeBytes(nameNumberString);

					raf.writeBytes(System.lineSeparator());

					System.out.println("New Recipes added Successfull !!! ");
					System.out.println("Hi " + newfoodItem+", well be added to the shop ");

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
		      File myObj = new File("C:\\Users\\Hashi\\Desktop\\New folder (6)\\oder.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println("......................................Avilabal Oders in shop....................................\n");
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

    }
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return null;
	}


}
