import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HowToPayTest  {
	HowToPay payment;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		payment = new HowToPay1();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPayWithCoins() {
		Purse.Builder builder = new Purse.Builder();
		Purse purse = builder.co500(2).co100(4).co050(1).co010(4).co005(1).co001(4).payment(payment).build();
	}
}
