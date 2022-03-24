package bakerycookconsumer;

import bakerycookproducer.BakeryCookProducer;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



public class BakeryCookConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Cook Consumer Service");
		serviceReference = context.getServiceReference(BakeryCookProducer.class.getName());
		BakeryCookProducer bakeryadminproducer = (BakeryCookProducer) context.getService(serviceReference);
		System.out.println(bakeryadminproducer.wellcomeCook());
		bakeryadminproducer.ViewAllRecord();

//		System.out.println("_________________________________ Bakery Shop Add New Recipes _________________________________\n");
//		System.out.println("Item Categorys :Bars\tBreads\tBreakfast Products\tCookies\tDessertsEnter\n ");
//		System.out.println("Enter food Item ?");
//		String bcfoodItem = sc.next();
//		System.out.println("Enter recipes Name ?");
//		String bcrecipesName = sc.next();
//		System.out.println("Enter Driscription ?");
//		String bcDriscription = sc.next();
//		bakeryadminproducer.insertnewRecipes(bcfoodItem , bcrecipesName ,bcDriscription);

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Cook Consumer Stop !!!");
		if(serviceReference != null) {
			context.ungetService(serviceReference);
		}
	}

}
