import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {

	public static void main(String[] args) {
		
		boolean exit = false;
		Scanner userInput = new Scanner(System.in);
		VendingMachine vend = new VendingMachine();
		int userChoice = 0;
		
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
				if(userChoice <= vend.getInventorySize()) {
					vend.purchaseProduct(userChoice);
				}
				else {
					System.out.println("Sorry, that is an invalid choice.");
				}
				
			} 
			else {
				
				vend.putMoney(100);
			} 
		}
		System.exit(0);
	}

}
