import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

	public String[] mainMenu = new String[] {"1) View Products", "2) Purchase Item", "3) Insert Money"};

	public Map<String, Double> products = new HashMap<String, Double>() {
		{
			put("Cola", (double)1);
			put("Chips", (double).5);
			put("Candy", (double).65);
		}
	};
	
}
