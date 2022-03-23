package bakeryadminconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import bakeryadminproducer.BakeryAdminProducer;

public class BakeryAdminConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;

	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Adamin Consumer Service");
		serviceReference = context.getServiceReference(BakeryAdminProducer.class.getName());
		BakeryAdminProducer bakeryadminproducer = (BakeryAdminProducer) context.getService(serviceReference);
		System.out.println(bakeryadminproducer.myName());
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}
