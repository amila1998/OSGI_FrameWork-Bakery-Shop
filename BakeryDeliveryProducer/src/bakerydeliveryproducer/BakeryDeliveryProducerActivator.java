package bakerydeliveryproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class BakeryDeliveryProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Delivery Producer Start");
		BakeryDeliveryProducer bakeryDeliveryproducer = (BakeryDeliveryProducer) new ProducerBakeryDelivery();
		publishServiceRegistration = context.registerService(BakeryDeliveryProducer.class.getName(), bakeryDeliveryproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Bakery Delivery Producer Stop");
		publishServiceRegistration.unregister();
	}

}
