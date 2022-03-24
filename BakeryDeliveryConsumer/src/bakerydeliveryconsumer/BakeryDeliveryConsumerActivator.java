package bakerydeliveryconsumer;

import bakerydeliveryproducer.BakeryDeliveryProducer;
import bakeryitemsproducer.BakeryItemsProducer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;




public class BakeryDeliveryConsumerActivator implements BundleActivator {
	Scanner sc = new Scanner(System.in);
	boolean logingSuccMsg = false;
	ServiceReference serviceReference,serviceReferencecustomerItems;

	public void start(BundleContext context) throws Exception {
		serviceReference = context.getServiceReference(BakeryDeliveryProducer.class.getName());
		BakeryDeliveryProducer bakeryDeliveryProducer =  (BakeryDeliveryProducer) context.getService(serviceReference);
		
		serviceReferencecustomerItems = context.getServiceReference(BakeryItemsProducer.class.getName());
		BakeryItemsProducer bakeryItemsProducer = (BakeryItemsProducer) context.getService(serviceReferencecustomerItems);
	
		System.out.println(bakeryDeliveryProducer.wellcome());
		while(logingSuccMsg==false) {
			logingSuccMsg = bakeryDeliveryProducer.loggingSucc();
			if(logingSuccMsg==true) {
				break;
			}
			
			
					System.out.println("_________________________________ Bakery Driver Login _________________________________\n");
					System.out.println("Enter Your Username ?");
					String bcuName = sc.next();
					System.out.println("Enter Your Password ?");
					String bcPass = sc.next();
					bakeryDeliveryProducer.Dlogin(bcuName, bcPass);	
					
				}
		
		bakeryDeliveryProducer.showList();
	
	
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Delivery Consumer Stop !!!");
		if(serviceReference != null) {
			context.ungetService(serviceReference);
		}
		if(serviceReferencecustomerItems != null) {
			context.ungetService(serviceReferencecustomerItems);
		}
	}

}
