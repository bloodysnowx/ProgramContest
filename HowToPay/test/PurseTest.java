import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PurseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPay() {
		Purse purse = new Purse.Builder().co500(1).co100(4).co050(3).co010(9).co005(1).co001(4).build();
		assertEquals(1, purse.pay(500));
		assertEquals(1, purse.pay(100));
		assertEquals(1, purse.pay(50));
		assertEquals(1, purse.pay(10));
		assertEquals(1, purse.pay(5));
		assertEquals(1, purse.pay(1));
		
		assertEquals(2, purse.pay(600));
		assertEquals(3, purse.pay(700));
		assertEquals(4, purse.pay(800));
		assertEquals(5, purse.pay(900));
		assertEquals(7, purse.pay(1000));
		assertEquals(13, purse.pay(1100));
	}

}
