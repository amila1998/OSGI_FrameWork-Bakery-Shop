package bakeryadminproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class BakeryAdminProducerActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Bakery Admin Producer Start");
		BakeryAdminProducer bakeryAdminproducer = (BakeryAdminProducer) new ProducerBakeryAdmin();
		publishServiceRegistration = context.registerService(BakeryAdminProducer.class.getName(), bakeryAdminproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Admin Producer Stop");
		publishServiceRegistration.unregister();
	}

}
