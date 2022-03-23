package bakeryadminconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BakeryAdminConsumerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BakeryAdminConsumerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BakeryAdminConsumerActivator.context = null;
	}

}
