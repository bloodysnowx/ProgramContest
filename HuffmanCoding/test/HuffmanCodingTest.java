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
		byte[] src = "aabbab".getBytes();
		byte[] expected = "a=0,b=1;001101".getBytes();		
		assertEquals(expected, src);
	}

	@Test
	public void testDeCompress() {
		byte[] src = "a=0,b=1;001101".getBytes();
		byte[] expected = "aabbab".getBytes();
		assertEquals(expected, src);
	}

}
