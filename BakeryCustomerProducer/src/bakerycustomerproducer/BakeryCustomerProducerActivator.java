package bakerycustomerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BakeryCustomerProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Customer Producer Start");
		BakeryCustomerProducer bakerycustomerproducer = (BakeryCustomerProducer) new ProducerBakeryCustomer();
		publishServiceRegistration = context.registerService(BakeryCustomerProducer.class.getName(), bakerycustomerproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Bakery Customer Producer Stop");
		publishServiceRegistration.unregister();
	}

}
