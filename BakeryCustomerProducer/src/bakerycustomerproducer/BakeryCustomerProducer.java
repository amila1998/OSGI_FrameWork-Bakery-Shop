package bakerycustomerproducer;

public interface BakeryCustomerProducer {
	public String wellcome();
	public void insertProducerBakeryCustomer(String name , String address , String email, String password);
	public String display();
	public void customerLogin(String name, String phone);
	
}
