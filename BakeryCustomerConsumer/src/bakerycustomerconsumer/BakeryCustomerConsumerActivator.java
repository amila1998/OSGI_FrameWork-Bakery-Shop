package bakerycustomerconsumer;

import bakeryadminproducer.BakeryAdminProducer;
import bakerycustomerproducer.BakeryCustomerProducer;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class BakeryCustomerConsumerActivator implements BundleActivator {

	ServiceReference serviceReference,serviceReference2;

	public void start(BundleContext context) throws Exception {
		String decision;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Start Consumer Service");
		serviceReference = context.getServiceReference(BakeryCustomerProducer.class.getName());
		BakeryCustomerProducer bakeryCustomerProducer = (BakeryCustomerProducer) context.getService(serviceReference);
		
		
		
		System.out.println(bakeryCustomerProducer.wellcome());
		System.out.println("Do Have an Account ?(Y/N)");
		decision = sc.next();
		
		while(!decision.equals("Y")||!decision.equals("y")|| !decision.equals("N")||!decision.equals("n")){
			
			
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
				System.out.println(bakeryCustomerProducer.display());	
							
				
				serviceReference2 = context.getServiceReference(BakeryAdminProducer.class.getName());
				BakeryAdminProducer bakeryAdminProducer = (BakeryAdminProducer) context.getService(serviceReference2);
				System.out.println(bakeryAdminProducer.myName());
				break;
			}else {
				System.out.println("Wrong Input!!");
				System.out.println("You Have a Account ?");
				decision = sc.next();
				
			}
		}
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!!");
		if(serviceReference != null) {
			context.ungetService(serviceReference);
		}
		if(serviceReference2 != null) {
			context.ungetService(serviceReference2);
		}
		
	}

}
