import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class VendingMachine {

	public String[] mainMenu = new String[] {"1) View Products", "2) Purchase Item", "3) Insert Money"};
	public String purchaseMenu = "Please enter product number:";
	private String[] depositMenu = new String[]	{"Quarter", "Nickel", "Dime"};
	public ArrayList<Product> products = new ArrayList<Product>();
	public int balance = 0;
	private int minBalance;
	
	public VendingMachine() {
		populateVendingMachine();
		for(Product cost : products) {
			if(cost.getPrice() > minBalance) {
				minBalance = cost.getPrice();
			}
		}
	}
	
	public void showMainMenu() {
		System.out.println(mainMenu[0]);
		System.out.println(mainMenu[1]);
		System.out.println(mainMenu[2]);
		System.out.println();
		System.out.println("Current balance: " + toString());
		if(getBalance() < minBalance) {
			System.out.println("INSERT COINS");
		}
	}
	
	public void listProducts() {
		for(int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ") " + products.get(i).getName() + "     " + products.get(i).toString() + "     " + products.get(i).getInventory());
		}
		System.out.println();
	}
	
	private void populateVendingMachine() {
		products.add(new Product("Cola", 100));
		products.add(new Product("Chips", 50));
		products.add(new Product("Candy", 65));
	}
	
	public void putMoney(int amount) {
		balance += amount;
	}
	
	public int getInventorySize() {
		return products.size();
	}
	
	public void purchaseMenu() {
		System.out.println(purchaseMenu);
	}
	
	public Product purchaseProduct(int productNumber) {
		balance -= products.get(productNumber - 1).getPrice();
		products.get(productNumber - 1).removeOneFromInventory();
		return products.get(productNumber - 1);
	}
	
	public int getBalance() {
		return balance;
	}
	
	public Product getProduct(int productNumber) {
		return products.get(productNumber - 1);
	}
	
	public void displayPurchase(Product product) {
		System.out.println("Thank you for purchasing " + product.getName() + ".");
		System.out.println("Your balance is " + toString());
	}
	
	public void displayDepositMenu() {
		System.out.println("Please deposit one of the following types of coins: ");
		for(int i = 0; i < depositMenu.length; i++) {
			System.out.println(depositMenu[i]);
		}
	}
	
	public int checkMoney(String input) {
		if(input.equalsIgnoreCase("quarter") || input.equals("25")) {
			return 25;
		}
		else if (input.equalsIgnoreCase("dime") || input.equals("10")) {
			return 10;
		}
		else if (input.equalsIgnoreCase("nickel") || input.equals("5")) {
			return 5;
		}
		else {
			System.out.println("We don't accept those.");
			return 0;
		}
	}
	
	public void getChange() {
		System.out.println("Change:");
		if(balance == 0) {
			System.out.println("$0.00");
		}
		
		if(balance > 25) {
			System.out.println("Quarters: " + balance / 25);
			balance = balance % 25;
		}
		
		if(balance > 10) {
			System.out.println("Dimes: " + balance / 10);
			balance = balance % 10;
		}
		
		if(balance > 5) {
			System.out.println("Nickels: " + balance / 5);
			balance = balance % 5;
		}
	}
	
	@Override
	public String toString() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
		String s = n.format(balance / 100.0);
		return s;
	}
	
}
