import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VendingMachine {

	public String[] mainMenu = new String[] {"1) View Products", "2) Purchase Item", "3) Insert Money"};
	public String purchaseMenu = "Please enter product number:";
	public ArrayList<Product> products = new ArrayList<Product>();
	public int balance = 0;
	
	public VendingMachine() {
		populateVendingMachine();
	}
	
	private void populateVendingMachine() {
		products.add(new Product("Cola", 100));
		products.add(new Product("Chips", 50));
		products.add(new Product("Candy", 65));
	}
	
	public void putMoney(int amount) {
		balance += amount;
	}
	
	public Product purchaseProduct(int productNumber) {
		balance -= products.get(productNumber - 1).getPrice();
		return products.get(productNumber - 1);
	}
	
	public int getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
		String s = n.format(balance / 100.0);
		return s;
	}
	
}
