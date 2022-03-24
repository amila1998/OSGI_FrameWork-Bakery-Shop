package bakerycookproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class BakeryCookProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	

	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Cook Producer Start");
		BakeryCookProducer bakeryCookProducer = (BakeryCookProducer) new ProducerBakeryCook();
		publishServiceRegistration = context.registerService(BakeryCookProducer.class.getName(), bakeryCookProducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Bakery Cook Producer Stop");
		publishServiceRegistration.unregister();
	}

}
