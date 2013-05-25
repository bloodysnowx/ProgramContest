import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PuddleSearchTest {

	PuddleSearch obj;

	@Before
	public void setUp() throws Exception {
		obj = new PuddleSearch2();
	}

	public int[][] convert(String[] puddle_str) {
		int[][] puddle = new int[puddle_str.length + 2][puddle_str[0].length() + 2];
		for (int i = 0; i < puddle_str.length; ++i) {
			for (int j = 0; j < puddle_str[i].length(); ++j) {
				if (puddle_str[i].charAt(j) == 'w') {
					puddle[i + 1][j + 1] = 1;
				}
			}
		}

		return puddle;
	}

	@Test
	public void testSearch1() {
		String[] puddle_str0 = { "." };
		assertEquals(0, obj.search(convert(puddle_str0)));
		String[] puddle_str1 = { "w" };
		assertEquals(1, obj.search(convert(puddle_str1)));
	}

	@Test
	public void testSearch2() {
		// @formatter:off
		String[] puddle_str0 = { 
				"..", 
				".." };
		assertEquals(0, obj.search(convert(puddle_str0)));
		String[] puddle_str1 = { 
				".w", 
				"w." };
		assertEquals(1, obj.search(convert(puddle_str1)));
		String[] puddle_str2 = { 
				"ww", 
				"ww" };
		assertEquals(1, obj.search(convert(puddle_str1)));
		// @formatter:on
	}

	@Test
	public void testSearch3() {
		// @formatter:off
		String[] puddle_str = { 
				"w........ww.", 
				".www.....www", 
				"....ww...ww.",
				".........ww.", 
				".........w..", 
				"..w......w..", 
				".w.w.....ww.",
				"w.w.w.....w.", 
				".w.w......w.", 
				"..w.......w." };
		// @formatter:on
		int[][] puddle = convert(puddle_str);
		assertEquals(3, obj.search(puddle));
	}

	@Test
	public void testSearch4() {
		// @formatter:off
		String[] puddle_str = { 
				"w........ww....w....w..........", 
				".www.....www...ww....w.........", 
				"....ww...ww.....w.....w........",
				".........ww......w.....w.......", 
				".........w........wwwww........", 
				"..w......w.....................", 
				".w.w.....ww....................",
				"w.w.w.....w....................", 
				".w.w......w....................", 
				"..w.......w...................." };
		// @formatter:on
		int[][] puddle = convert(puddle_str);
		assertEquals(4, obj.search(puddle));
	}
}
