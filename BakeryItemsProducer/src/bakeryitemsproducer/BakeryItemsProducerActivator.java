package bakeryitemsproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class BakeryItemsProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Items Producer Start");
		BakeryItemsProducer bakeryitemproducer = (BakeryItemsProducer) new ProducerBakeryItems();
		publishServiceRegistration = context.registerService(BakeryItemsProducer.class.getName(), bakeryitemproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Item Producer Stop");
		publishServiceRegistration.unregister();
	}

}
