package bakeryadminconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



import bakeryadminproducer.BakeryAdminProducer;

public class BakeryAdminConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner sc = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Adamin Consumer Service");
		serviceReference = context.getServiceReference(BakeryAdminProducer.class.getName());
		BakeryAdminProducer bakeryadminproducer = (BakeryAdminProducer) context.getService(serviceReference);
		System.out.println(bakeryadminproducer.myName());
		
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
		
		
		
		
		
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}
