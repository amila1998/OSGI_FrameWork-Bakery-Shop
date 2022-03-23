package bakerycookproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BakeryCookProducerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BakeryCookProducerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BakeryCookProducerActivator.context = null;
	}

}
