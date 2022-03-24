package bakerydeliveryconsumer;

import bakerydeliveryproducer.BakeryDeliveryProducer;
import bakeryitemsproducer.BakeryItemsProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;




public class BakeryDeliveryConsumerActivator implements BundleActivator {

	ServiceReference serviceReference,serviceReferencecustomerItems;

	public void start(BundleContext context) throws Exception {
		serviceReference = context.getServiceReference(BakeryDeliveryProducer.class.getName());
		BakeryDeliveryProducer bakeryDeliveryProducer =  (BakeryDeliveryProducer) context.getService(serviceReference);
		
		serviceReferencecustomerItems = context.getServiceReference(BakeryItemsProducer.class.getName());
		BakeryItemsProducer bakeryItemsProducer = (BakeryItemsProducer) context.getService(serviceReferencecustomerItems);
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
