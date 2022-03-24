package bakerycook;

public class CookRecipes {
	private String foodItem;
	private String recipesName;
	private String  driscription;

	public CookRecipes(){}


	public CookRecipes(String foodItem, String recipesName, String driscription) {
		super();
		this.foodItem = foodItem;
		this.recipesName = recipesName;
		this.driscription = driscription;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public String getRecipesName() {
		return recipesName;
	}
	public void setRecipesName(String recipesName) {
		this.recipesName = recipesName;
	}
	public String getDriscription() {
		return driscription;
	}
	public void setDriscription(String driscription) {
		this.driscription = driscription;
	}

}