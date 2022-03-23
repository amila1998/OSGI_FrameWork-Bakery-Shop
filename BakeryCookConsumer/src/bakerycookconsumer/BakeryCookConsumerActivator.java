package bakerycookconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BakeryCookConsumerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BakeryCookConsumerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BakeryCookConsumerActivator.context = null;
	}

}
