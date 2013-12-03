
/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/12/03
 * Time: 9:08
 * To change this template use File | Settings | File Templates.
 */

import org.junit.After
import org.junit.Before

import static org.junit.Assert.*;
import org.junit.Test;
import Main;

class MainTest {
    @Before
    void setUp() {
    }

    @After
    void tearDown() {
    }

    @Test
    void testMain() {

    }

    @Test
    void testSolve() {

    }

    @Test
    void testSolve_01() {
        assertEquals(Main.solve(1, 500 * 1000, 0.5), 0.5, 0.01);
    }

    @Test
    void testSolve_02() {
        assertEquals(Main.solve(3, 600 * 1000, 0.75), 0.84375, 0.01);
    }


}
