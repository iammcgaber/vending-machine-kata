import static org.junit.Assert.*;

import org.junit.After;
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
	
	@After
	public void reset() {
		customer = new Customer();
		vend = new VendingMachine();
	}
	
	@Test
	public void vending_machine_is_not_void() {
		Assert.assertNotNull(vend);
	}
	
	@Test
	public void product_class_is_not_void_and_has_name() {
		Product chips = new Product("Chips", 100);
		
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
	
	@Test
	public void vending_machine_menu_cola() {
		
		Assert.assertEquals("Cola", vend.products.get(0).getName());
	}
	
	@Test
	public void vending_machine_menu_has_chip_price() {
		Assert.assertEquals("$1.00", vend.products.get(0).toString());
	}
	
	@Test
	public void balance_before_inserting_money_is_0() {
		Assert.assertEquals(0, vend.getBalance());
	}
	
	@Test
	public void able_to_deposit_money() {
		vend.putMoney(25);
		Assert.assertEquals(25, vend.getBalance());
		System.out.println(vend.getBalance());
	}
	
	@Test
	public void able_to_purchase_product() {
		Assert.assertEquals("Cola", vend.purchaseProduct(1).getName());
		Assert.assertEquals(-100, vend.getBalance());
	}
	
	

}
