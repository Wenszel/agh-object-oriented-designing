package pl.edu.agh.dronka.shop.model;


import java.util.*;

public abstract class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;

	private boolean secondhand;

	private boolean polish;


	public Item(String name, Category category, int price, int quantity, boolean secondhand, boolean polish) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.secondhand = secondhand;
		this.polish = polish;
	}

	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("Nazwa", name);
		properties.put("Cena", price);
		properties.put("Kategoria", category.getDisplayName());
		properties.put("Ilość", quantity);
		properties.put("Tanie bo polskie", polish);
		properties.put("Używany", secondhand);
		return properties;
	}

	public Item() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondhand(boolean secondhand) {
		this.secondhand = secondhand;
	}

	public boolean isSecondhand() {
		return secondhand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static List<String> getBooleansNames() {
		List<String> booleansNames = new ArrayList<>();
		booleansNames.add("Secondhand");
		booleansNames.add("Polish");
		return booleansNames;
	}

	public boolean booleanEquals(Item item) {
		return (this.secondhand == item.secondhand || !this.secondhand) && (this.polish == item.polish || !this.polish);
	}

	public static EnumSet<BooleanProperty> getBooleanProperties() {
		EnumSet<BooleanProperty> booleanProperties = EnumSet.noneOf(BooleanProperty.class);
		booleanProperties.add(BooleanProperty.SECONDHAND);
		booleanProperties.add(BooleanProperty.POLISH);
		return booleanProperties;
	}

	public void setBoolean(BooleanProperty booleanProperty, boolean value) {
		switch (booleanProperty) {
			case SECONDHAND:
				this.secondhand = value;
				break;
			case POLISH:
				this.polish = value;
				break;
			default:
				break;
		}
	}

	public void setProperty(String propertyName, Object propertyValue) {
		System.out.println("Item: setProperty" + propertyName +" "+propertyValue);
		switch (propertyName) {
			case "Name":
				this.name = (String) propertyValue;
				break;
			case "Category":
				this.category = (Category) propertyValue;
				break;
			case "Price":
				this.price = (int) propertyValue;
				break;
			case "Quantity":
				this.quantity = (int) propertyValue;
				break;
			case "Secondhand":
				this.secondhand = (boolean) propertyValue;
				break;
			case "Polish":
				this.polish = (boolean) propertyValue;
				break;
			default:
				break;
		}
	}
}
