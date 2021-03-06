/** 1つの仕事 */
public class Job {
	private final int start;
	private final int end;

	public Job(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	/** 含まれているかどうか */
	public boolean isInclude(Job job) {
		return (this.start <= job.start && job.end <= this.end);
	}

	/** 重なっているかどうか */
	public boolean isSwamped(Job job) {
		return !(this.end <= job.start | job.end <= this.start);
	}
}
