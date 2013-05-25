import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HowToChoose2 implements HowToChoose {

	@Override
	public Timetable calcMostSuitedTimetable(Timetable timetable) {
		List<Job> settledJobs = new ArrayList<Job>();
		List<Job> jobs = timetable.getTimetable();
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job arg0, Job arg1) {
				return arg0.getEnd() - arg1.getEnd();
			}
		});
		
		int now = 0;
		for(Job job : jobs)
		{
			if(job.getStart() >= now) {
				now = job.getEnd();
				settledJobs.add(job);
			}
		}
		
		return new Timetable.Builder().Add(settledJobs).build();
	}

}
