package bakerycustomerconsumer;

import bakeryadminproducer.BakeryAdminProducer;
import bakerycustomerproducer.BakeryCustomerProducer;
import bakeryitemsproducer.BakeryItemsProducer;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class BakeryCustomerConsumerActivator implements BundleActivator {

	ServiceReference serviceReference,serviceReference2,serviceReferencecustomerItems;

	public void start(BundleContext context) throws Exception {
		String decision = "y";
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Start Consumer Service");
		serviceReference = context.getServiceReference(BakeryCustomerProducer.class.getName());
		BakeryCustomerProducer bakeryCustomerProducer = (BakeryCustomerProducer) context.getService(serviceReference);
		
		serviceReferencecustomerItems = context.getServiceReference(BakeryItemsProducer.class.getName());
		BakeryItemsProducer bakeryItemsProducer = (BakeryItemsProducer) context.getService(serviceReferencecustomerItems);
		
		
		
		System.out.println(bakeryCustomerProducer.wellcome());
		
		
		do{
			System.out.println("You Have a Account ?(Y/N)");
			decision = sc.next();
			if(decision.equals("Y")||decision.equals("y")) {
				System.out.println("_________________________________ Bakery Shop Customer Login _________________________________\n");
				System.out.println("Enter Your Name ?");
				String bcName = sc.next();
				System.out.println("Enter Your Phone Number ?");
				String bcPhone = sc.next();
				bakeryCustomerProducer.customerLogin(bcName, bcPhone);	
				break;
			}else if(decision.equals("N")||decision.equals("n")) {
				System.out.println("_________________________________ Bakery Shop Customer Registration _________________________________\n");
				System.out.println("Enter Your Name ?");
				String bcName = sc.next();
				System.out.println("Enter Your Phone Number ?");
				String bcPhone = sc.next();
				System.out.println("Enter Your Email ?");
				String bcEmail = sc.next();
				System.out.println("Enter Your Address ?");
				String bcAddress = sc.next();
				bakeryCustomerProducer.insertProducerBakeryCustomer(bcName, bcAddress , bcEmail, bcPhone);
				break;
			}else {
			
				System.out.println("Wrong Input!!");
			}
		}while(!decision.equals("Y")||!decision.equals("y")|| !decision.equals("N")||!decision.equals("n"));
		bakeryItemsProducer.itemcustomerwellcome();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!!");
		if(serviceReference != null) {
			context.ungetService(serviceReference);
		}
		if(serviceReference2 != null) {
			context.ungetService(serviceReference2);
		}
		if(serviceReferencecustomerItems != null) {
			context.ungetService(serviceReferencecustomerItems);
		}
		
	}

}
