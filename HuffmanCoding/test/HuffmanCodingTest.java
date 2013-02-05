import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class HuffmanCodingTest {
	private Coding coding;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		coding = new HuffmanCoding();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompress() {
		String src = "aabbab";
		String expected = "a=0,b=1;001101";
		assertEquals(expected, coding.compress(src));
	}

	@Test
	public void testDeCompress() {
		String src = "a=0,b=1;001101";
		String expected = "aabbab";
		assertEquals(expected, coding.deCompress(src));
		
		src = "a=1,b=01,c=000,d=001;11111101111001000";
		expected = "aaaaaabaaadc";
		assertEquals(expected, coding.deCompress(src));
	}

}
