import java.text.NumberFormat;
import java.util.Locale;

public class Product {
	private String name;
	private int price;
	
	public Product (String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
		String s = n.format(price / 100.0);
		return s;
	}
}
