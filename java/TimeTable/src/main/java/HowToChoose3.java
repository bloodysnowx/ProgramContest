import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HowToChoose3 implements HowToChoose {
    @Override
    public Timetable calcMostSuitedTimetable(Timetable timetable) {
        List<Job> settledJobs = new ArrayList<Job>();
        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>(11, new Comparator<Job>() {
            @Override public int compare(Job o1, Job o2) { return o1.getEnd() - o2.getEnd(); }
        });
        jobPriorityQueue.addAll(timetable.getTimetable());
        int now = 0;
        Job job;
        while((job = jobPriorityQueue.poll()) != null)
        {
            if(job.getStart() >= now) {
                now = job.getEnd();
                settledJobs.add(job);
            }
        }
        return new Timetable.Builder().Add(settledJobs).build();
    }
}
