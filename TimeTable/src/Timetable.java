import java.util.ArrayList;
import java.util.List;

public class Timetable {
	private final List<Job> jobs;
	private Timetable(Builder builder) {
		this.jobs = builder.jobs;
	}
	
	public List<Job> getTimetable() {
		return this.jobs;
	}
	
	public int getJobsCount() {
		return this.jobs.size();
	}
	
	public static class Builder {
		private final List<Job> jobs = new ArrayList<Job>();
		
		public Builder Add(Job job) {
			jobs.add(job);
			return this;
		}
		
		public Builder Add(List<Job> jobs) {
			this.jobs.addAll(jobs);
			return this;
		}
		
		public Timetable build() {
			return new Timetable(this);
		}
	}
}
