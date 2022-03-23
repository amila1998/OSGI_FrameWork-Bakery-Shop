package bakeryitemsproducer;

public class ProducerBakeryItems implements BakeryItemsProducer{
	

	@Override
	public void itemcustomerwellcome() {
		System.out.println("_________________________________ Bakery Items _________________________________\n\n"
				+ "1) Bars\n"
				+ "2) Breads\n"
				+ "3) Breakfast Products\n"
				+ "4) Cookies\n"
				+ "5) Desserts\n");
		
		
	}

}
