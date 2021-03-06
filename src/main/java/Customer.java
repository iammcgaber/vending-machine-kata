import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {

	public static void main(String[] args) {
		
		boolean exit = false;
		Scanner userInput = new Scanner(System.in);
		VendingMachine vend = new VendingMachine();
		int userChoice = 0;
		String deposit = "";
		
		while(!exit) {
			vend.showMainMenu();
			try {
				userChoice = userInput.nextInt();
				System.out.println();
			}
			catch (InputMismatchException ex) {
				System.out.println("Please select a valid number");
				userInput.next();
			}
				
			while(userChoice != 1 && userChoice != 2 && userChoice != 3) {
				System.out.println("Please select a valid menu option"); 
				userChoice = userInput.nextInt();
				System.out.println();
			} 
			
			if(userChoice == 1) {
				vend.listProducts();
			} 
			else if(userChoice == 2) {
				vend.purchaseMenu();
				try {
					userChoice = userInput.nextInt();
					System.out.println();
				}
				catch (InputMismatchException ex) {
					System.out.println("Please select a valid number");
					userInput.next();
				}
				
				if (vend.getProduct(userChoice).getPrice() > vend.getBalance()) {
					System.out.println("Sorry, you do not have enough money.  Please enter more money.");
					System.out.println("PRICE: " + vend.getProduct(userChoice).toString());
					System.out.println();
				}
				else if(userChoice <= vend.getInventorySize()) {
					if(vend.getProduct(userChoice).getInventory() > 0) {
					Product purchasedProduct = vend.purchaseProduct(userChoice);
					vend.displayPurchase(purchasedProduct);
					vend.getChange();
					}
					else {
						System.out.println(vend.getProduct(userChoice).getName() + " are SOLD OUT");
					}
				}
				else {
					System.out.println("Sorry, that is an invalid choice.");
				}
				
			} 
			else {
				try {
					vend.displayDepositMenu();
					deposit = userInput.next();
					System.out.println();
				}
				catch(InputMismatchException ex) {
					System.out.println("Please insert a Quarter, Dime, or Nickel:");
					userInput.next();
				}
				
				int value = vend.checkMoney(deposit);
				vend.putMoney(value);
			} 
		}
		System.exit(0);
	}

}
