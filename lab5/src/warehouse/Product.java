package warehouse;

public class Product implements Component{
	private double price;
	private String name;
	
	public Product(double price, String name) {
		this.price = price;
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void print(int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println("Product: " + name + " price: " + price);
	}
}
