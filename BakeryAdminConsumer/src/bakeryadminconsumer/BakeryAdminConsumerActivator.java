package bakeryadminconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import bakeryadminproducer.BakeryAdminProducer;
import bakeryitemsproducer.BakeryItemsProducer;

public class BakeryAdminConsumerActivator implements BundleActivator {

	ServiceReference serviceReference, serviceReferenceItems;
	Scanner sc = new Scanner(System.in);
	String decision = "y";
	boolean itemsSaveSuccMsg = false;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Adamin Consumer Service");
		serviceReference = context.getServiceReference(BakeryAdminProducer.class.getName());
		BakeryAdminProducer bakeryadminproducer = (BakeryAdminProducer) context.getService(serviceReference);
		
		serviceReferenceItems = context.getServiceReference(BakeryItemsProducer.class.getName());
		BakeryItemsProducer bakeryitemsproducer =(BakeryItemsProducer) context.getService(serviceReferenceItems);
		
			
		System.out.println(bakeryadminproducer.myName());
		
		System.out.println("Choose a Option ?\n"
				+ "1. Add Bakery Items\n"
				+ "2. Add a Delivery Person\n");
		String option = sc.next();
		int optionI = Integer.parseInt(option);
	
		switch (optionI) {
		  case 1:{
			  System.out.println("_________________________________ Bakery Shop Add Items _________________________________\n");
				System.out.println("Enter Item ID ?");
				String bcID = sc.next();
				System.out.println("Enter Item Name ?");
				String bcName = sc.next();
				System.out.println("Item Categorys :Bars\tBreads\tBreakfast Products\tCookies\tDessertsEnter\n Item Category ?");
				String bcCategory = sc.next();
				System.out.println("Enter Item Price ?");
				String bcPrice = sc.next();
				System.out.println("Enter Item Qty ?");
				String bcQty = sc.next();
				
			  bakeryitemsproducer.addBItems(bcID, bcName , bcCategory, bcPrice, bcQty);
			  break;
		  }
		  case 2:{
			  	System.out.println("_________________________________ Bakery Shop diver Registration _________________________________\n");
				System.out.println("Enter Your Name ?");
				String bcName = sc.next();
				System.out.println("Enter Your Phone Number ?");
				String bcPhone = sc.next();
				System.out.println("Enter Your User Name ?");
				String bcUserName = sc.next();
				System.out.println("Enter Your Password ?");
				String bcPassword = sc.next();

				bakeryadminproducer.insertDeliveryPreson(bcName, bcPhone , bcUserName, bcPassword);
				System.out.println(bakeryadminproducer.DeliveryPresonDisplay());	

		    break;
		   }
		  default:{
			  System.out.println("Wrong Input !!!");
			  break;
		  }
		  
		}
		

		



	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}
