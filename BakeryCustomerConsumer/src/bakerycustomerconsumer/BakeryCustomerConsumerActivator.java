package bakerycustomerconsumer;

import bakeryadminproducer.BakeryAdminProducer;
import bakerycustomerproducer.BakeryCustomerProducer;
import bakeryitemsproducer.BakeryItemsProducer;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class BakeryCustomerConsumerActivator implements BundleActivator {

	ServiceReference serviceReference,serviceReference2,serviceReferencecustomerItems;

	public void start(BundleContext context) throws Exception {
		String decision = "y";
		Scanner sc = new Scanner(System.in);
		boolean logingSuccMsg = false;
		
		System.out.println("Start Consumer Service");
		serviceReference = context.getServiceReference(BakeryCustomerProducer.class.getName());
		BakeryCustomerProducer bakeryCustomerProducer = (BakeryCustomerProducer) context.getService(serviceReference);
		
		serviceReferencecustomerItems = context.getServiceReference(BakeryItemsProducer.class.getName());
		BakeryItemsProducer bakeryItemsProducer = (BakeryItemsProducer) context.getService(serviceReferencecustomerItems);
		
		
		
		System.out.println(bakeryCustomerProducer.wellcome());
		
		while(logingSuccMsg==false) {
			logingSuccMsg = bakeryCustomerProducer.loggingSucc();
			if(logingSuccMsg==true) {
				break;
			}
			do{
				System.out.println("You Have a Account ?(Y/N)");
				decision = sc.next();
				if(decision.equals("Y")||decision.equals("y")) {
					System.out.println("_________________________________ Bakery Shop Customer Login _________________________________\n");
					System.out.println("Enter Your Name ?");
					String bcName = sc.next();
					System.out.println("Enter Your Phone Number ?");
					String bcPhone = sc.next();
					bakeryCustomerProducer.customerLogin(bcName, bcPhone);	
					
					break;
				}else if(decision.equals("N")||decision.equals("n")) {
					System.out.println("_________________________________ Bakery Shop Customer Registration _________________________________\n");
					System.out.println("Enter Your Name ?");
					String bcName = sc.next();
					System.out.println("Enter Your Phone Number ?");
					String bcPhone = sc.next();
					System.out.println("Enter Your Email ?");
					String bcEmail = sc.next();
					System.out.println("Enter Your Address ?");
					String bcAddress = sc.next();
					bakeryCustomerProducer.insertProducerBakeryCustomer(bcName, bcAddress , bcEmail, bcPhone);
					
					break;
				}else {
				
					System.out.println("Wrong Input!!");
				}
				
				
			}while(!decision.equals("Y")||!decision.equals("y")|| !decision.equals("N")||!decision.equals("n"));
		}
			String buyItemsDecision = "y";
			while(buyItemsDecision.equals("y")||buyItemsDecision.equals("Y")) {
				System.out.println("Do you Want To Buy Items ?(Y/N)");
				buyItemsDecision = sc.next();
				if(buyItemsDecision.equals("n")||buyItemsDecision.equals("N")) {
					
					
					bakeryItemsProducer.showMyBill();
					System.out.println("Do you Want To Deliver ?(Y/N)");
					String wantdeliverDecision = sc.next();
					if(wantdeliverDecision.equals("n")||wantdeliverDecision.equals("N")) {
						
						bakeryItemsProducer.AddtoBillRegister("NO");
						
					}else if(wantdeliverDecision.equals("Y")||wantdeliverDecision.equals("y")) {
						
						bakeryItemsProducer.AddtoBillRegister("YES");
						
					}else {
						System.out.println("Wrong Input !!");
						wantdeliverDecision = "y";
						continue;
					}
					String s = sc.next();
					break;
				}
				bakeryItemsProducer.itemcustomerwellcome();
				System.out.println("Choose a Category ?");
				String iCategory = sc.next();
				bakeryItemsProducer.searchItemByCategory(iCategory);
				boolean isCategoryEmpty=bakeryItemsProducer.isEmptyCategoryMsg();
				if(isCategoryEmpty==false) {
					String buyAnItemsDecision = "y";
					while(buyAnItemsDecision.equals("y")||buyAnItemsDecision.equals("Y")) {
						System.out.println("Do you Want To Buy Items Under this Catogery ?(Y/N)");
						buyAnItemsDecision = sc.next();
						if(buyAnItemsDecision.equals("n")||buyAnItemsDecision.equals("N")) {
							break;
						}
						System.out.println("Enter Item ID ?");
						String iID = sc.next();
						bakeryItemsProducer.searchItemByID(iID);
						String buyAnItemDecision = "y";
						while(buyAnItemDecision.equals("y")||buyAnItemDecision.equals("Y")) {
							System.out.println("Do you Want To Buy Item ?(Y/N)");
							buyAnItemDecision = sc.next();
							if(buyAnItemDecision.equals("n")||buyAnItemDecision.equals("N")) {
								break;
							}
							boolean qtyCheck = false;
							while(qtyCheck == false) {
								System.out.println("How many Qty you Need ?");
								String icQty = sc.next();
								qtyCheck=bakeryItemsProducer.checkQty(iID,icQty);
								if(qtyCheck == true) {
									//AddtoBill
									String myName=bakeryCustomerProducer.getMyName();
									bakeryItemsProducer.addToBill(myName, iID, icQty);
									break;
								}
								if(qtyCheck == false) {
									System.out.println("No Qty Available for this Request! and try less Qty");
									continue;
								}
								
							}
							
							
						}
					}
					
				}
			}
			
			
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Customer Consumer Stop !!!");
		if(serviceReference != null) {
			context.ungetService(serviceReference);
		}
		if(serviceReference2 != null) {
			context.ungetService(serviceReference2);
		}
		if(serviceReferencecustomerItems != null) {
			context.ungetService(serviceReferencecustomerItems);
		}
		
	}

}
