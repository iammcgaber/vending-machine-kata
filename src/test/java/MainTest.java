import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

	Customer customer;
	VendingMachine vend;
	
	@Before
	public void setup() {
		customer = new Customer();
		vend = new VendingMachine();
	}
	
	@Test
	public void vending_machine_is_not_void() {
		Assert.assertNotNull(vend);
	}
	
	@Test
	public void product_class_is_not_void() {
		Product chips = new Product("Chips", (double)1);
		
		Assert.assertNotNull(chips);
		Assert.assertEquals("Chips", chips.getName());
	}
	
	@Test
	public void customer_is_not_void() {
		Assert.assertNotNull(customer);
	}
	
	@Test
	public void vending_machine_menu_has_view_products() {
		Assert.assertEquals("1) View Products", vend.mainMenu[0]);
	}
	
	@Test
	public void vending_machine_menu_has_insert_money() {
		Assert.assertEquals("3) Insert Money", vend.mainMenu[2]);
	}

}
