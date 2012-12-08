import java.util.ArrayList;
import java.util.List;


public class Timetable {
	private final List<Job> jobs;
	private Timetable(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public class Builder {
		private final List<Job> jobs = new ArrayList<Job>();
		public Builder Add(Job job) {
			jobs.add(job);
			return this;
		}
		
		public Timetable build() {
			return new Timetable(jobs);
		}
	}
}
