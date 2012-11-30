import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MazeSearchTest {
	MazeSearch mazeSearch;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mazeSearch = new MazeSearch1();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearch() {
		// @formatter:off
		String[] mazeStr = { 
				"#S######.#", 
				"......#..#",
				".#.##.##.#",
				".#........",
				"##.##.####",
				"....#....#",
				".#######.#",
				"....#.....",
				".####.###.",
				"....#...G#"};
		// @formatter:on
		assertEquals(22, mazeSearch.search(convert(mazeStr)));
	}

	@Test
	public void testSearch1() {
		// @formatter:off
		String[] mazeStr = { 
				"#S#",
				"#G#"};
		// @formatter:on
		assertEquals(1, mazeSearch.search(convert(mazeStr)));
	}

	@Test
	public void testSearch2() {
		// @formatter:off
		String[] mazeStr = { 
				"#S#",
				"...",
				"#G#"};
		// @formatter:on
		assertEquals(2, mazeSearch.search(convert(mazeStr)));
	}

	@Test
	public void testSearch3() {
		// @formatter:off
		String[] mazeStr = { 
				"#S.#",
				"....",
				"....",
				"#G.#"};
		// @formatter:on
		assertEquals(3, mazeSearch.search(convert(mazeStr)));
	}

	@Test
	public void testSearch4() {
		// @formatter:off
		String[] mazeStr = { 
				"#S.#",
				"....",
				"....",
				"#.G#"};
		// @formatter:on
		assertEquals(4, mazeSearch.search(convert(mazeStr)));
	}

	@Test
	public void testSearch5() {
		// @formatter:off
		String[] mazeStr = { 
				"#S.#",
				".#..",
				"....",
				"#G.#"};
		// @formatter:on
		assertEquals(5, mazeSearch.search(convert(mazeStr)));
	}

	@Test
	public void testSearch6() {
		// @formatter:off
		String[] mazeStr = { 
				"#S.#",
				".#..",
				"....",
				".#..",
				"#G.#"};
		// @formatter:on
		assertEquals(6, mazeSearch.search(convert(mazeStr)));
	}

	private MazePattern[][] convert(String[] mazeStr) {
		MazePattern[][] maze = new MazePattern[mazeStr.length + 2][mazeStr[0]
				.length() + 2];

		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[i].length; ++j) {
				maze[i][j] = MazePattern.WALL;
			}
		}

		for (int i = 1; i < maze.length - 1; ++i) {
			for (int j = 1; j < maze[i].length - 1; ++j) {
				switch (mazeStr[i - 1].charAt(j - 1)) {
				case 'S':
					maze[i][j] = MazePattern.START;
					break;
				case 'G':
					maze[i][j] = MazePattern.GOAL;
					break;
				case '.':
					maze[i][j] = MazePattern.PASS;
				default:
					break;
				}
			}
		}
		return maze;
	}

}
