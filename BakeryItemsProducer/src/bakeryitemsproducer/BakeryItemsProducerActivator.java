package bakeryitemsproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BakeryItemsProducerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BakeryItemsProducerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BakeryItemsProducerActivator.context = null;
	}

}
