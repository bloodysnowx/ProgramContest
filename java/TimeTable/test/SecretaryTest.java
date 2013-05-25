import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecretaryTest {
	HowToChoose choose;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		choose = new HowToChoose1();
		// choose = new HowToChoose2();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSecretary() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGetBestSuitedTimetable1() {
		Timetable timetable = new Timetable.Builder().Add(5, 6).build();
		Secretary secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(5, 6).Add(5, 7).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(5, 8).Add(6, 10).Add(4, 7).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
	}
	
	@Test
	public void testGetBestSuitedTimetable2() {
		Timetable timetable = new Timetable.Builder().Add(5, 6).Add(6, 7).Add(5, 7).build();
		Secretary secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 3).Add(2, 4).Add(3, 5).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 3).Add(2, 4).Add(3, 5).Add(4, 6).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 3).Add(2, 4)
				.Add(3, 5).Add(4, 6).Add(3, 5).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
	}
	
	@Test
	public void testGetBestSuitedTimetable3() {
		Timetable timetable = new Timetable.Builder().Add(5, 6).Add(6, 7).Add(5, 7).Add(1, 3).build();
		Secretary secretary = new Secretary(timetable, choose);
		assertEquals(3, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 3).Add(2, 4).Add(3, 5).Add(4, 6).Add(5, 7).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(3, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 4).Add(5, 8).Add(9, 12)
				.Add(2, 5).Add(6, 9).Add(1, 4).Add(7, 10).Add(3, 7).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(3, secretary.getBestSuitedTimetable().getJobsCount());
	}
	
	@Test
	public void testGetBestSuitedTimetable4() {
		Timetable timetable = new Timetable.Builder().Add(5, 6).Add(6, 7).Add(5, 7).Add(1, 3).Add(7, 8).build();
		Secretary secretary = new Secretary(timetable, choose);
		assertEquals(4, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 3).Add(2, 4).Add(3, 5).Add(4, 6).Add(5, 7)
				.Add(6, 8).Add(7, 9).Add(8, 10).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(4, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(1, 4).Add(5, 8).Add(9, 12).Add(4, 6)
				.Add(2, 5).Add(6, 9).Add(1, 4).Add(7, 10).Add(3, 7).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(4, secretary.getBestSuitedTimetable().getJobsCount());
	}

}
