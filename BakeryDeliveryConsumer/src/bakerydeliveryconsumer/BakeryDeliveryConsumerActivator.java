package bakerydeliveryconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BakeryDeliveryConsumerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BakeryDeliveryConsumerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BakeryDeliveryConsumerActivator.context = null;
	}

}
