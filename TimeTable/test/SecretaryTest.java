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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSecretary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBestSuitedTimetable1() {
		Timetable timetable = new Timetable.Builder().Add(new Job(5, 6)).build();
		Secretary secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(new Job(5, 6)).Add(new Job(5, 7)).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(new Job(5, 8)).Add(new Job(6, 10)).Add(new Job(4, 7)).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
	}
	
	@Test
	public void testGetBestSuitedTimetable2() {
		Timetable timetable = new Timetable.Builder().Add(new Job(5, 6)).build();
		Secretary secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(new Job(5, 6)).Add(new Job(5, 7)).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(1, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(new Job(5, 6)).Add(new Job(6, 7)).Add(new Job(5, 7)).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(new Job(1, 3)).Add(new Job(2, 4)).Add(new Job(3, 5)).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
		
		timetable = new Timetable.Builder().Add(new Job(1, 3)).Add(new Job(2, 4)).Add(new Job(3, 5)).Add(new Job(4, 6)).build();
		secretary = new Secretary(timetable, choose);
		assertEquals(2, secretary.getBestSuitedTimetable().getJobsCount());
	}

}
