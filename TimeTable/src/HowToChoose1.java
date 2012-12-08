import java.util.ArrayList;
import java.util.List;

public class HowToChoose1 implements HowToChoose {
	/** 確定している仕事 */
	private final List<Job> settledJobs = new ArrayList<Job>();
	/** 選択余地のある仕事 */
	private final List<Job> choices = new ArrayList<Job>();
	
	@Override
 	public Timetable calcMostSuitedTimetable(Timetable timetable) {
		reset();
		List<Job> jobs = timetable.getTimetable();
		jobs = reduce(jobs);
		classify(jobs);
		List<Job> chosen = choose(choices);
		return new Timetable.Builder().Add(settledJobs).Add(chosen).build();
	}
	/** メンバ配列の初期化 */
	private void reset() {
		settledJobs.clear();
		choices.clear();
	}
	
	/** 他よりも明らかに不利な仕事を削除する */
	private List<Job> reduce(List<Job> jobs) {
		for(int i = jobs.size() - 1; i >= 0; --i) {
			if(isUseless(i, jobs)) {
				jobs.remove(i);
			}
		}
		return jobs;
	}
	/** 不要かどうかを判定する */
	private boolean isUseless(int position, List<Job> jobs) {
		for(int i = 0; i < jobs.size(); ++i) {
			if(i == position) continue;
			if(jobs.get(position).isInclude(jobs.get(i))) return true;
		}
		return false;
	}
	
	/** 確定で選択できる仕事と選択余地のある仕事を分類する */
	private void classify(List<Job> jobs) {
		for(int i = jobs.size() - 1; i >= 0; --i) {
			if(isSettled(i, jobs)) settledJobs.add(jobs.remove(i));
		}
		choices.addAll(jobs);
	}
	/** 確定の仕事かどうかを判定する */
	private boolean isSettled(int position, List<Job> jobs) {
		for(int i = 0; i < jobs.size(); ++i) {
			if(i == position) continue;
			if(jobs.get(position).isSwamped(jobs.get(i))) return false;
		}
		return true;
	}
	
	/** 最適な組み合わせを探索する */
	private List<Job> choose(List<Job> jobs) {
		boolean swamped[][] = calcSwamped(jobs);
		List<Integer> combinations = new ArrayList<Integer>();
		for(int i = 0; i < (1 << jobs.size()); ++i)
			if(isNoSwamped(i, swamped)) combinations.add(i);
		return chooseJobsFromCombination(jobs, getLongestCombination(combinations));
	}
	/** 与えられた組み合わせから仕事を選び出す */
	private List<Job> chooseJobsFromCombination(List<Job> jobs, int combination) {
		List<Job> chosen = new ArrayList<Job>();
		for(int i = 0; i < getBitLength(combination); ++i) {
			if(((combination >> i) & 1) == 1) chosen.add(jobs.get(i));
		}
		return chosen;
	}
	/** 最も長い組み合わせを返す */
	private int getLongestCombination(List<Integer> combinations) {
		int maxLength = 0;
		int longestCombination = 0;
		for(int i:combinations) {
			if(maxLength < getCount(i)) {
				maxLength = getCount(i);
				longestCombination = i;
			}
		}
		return longestCombination;
	}
	/** 与えられたbit列の組み合わせ数を返す */
	private int getCount(int i) {
		int count = 0;
		for(int j = 0; j < getBitLength(i); ++j)
			count += ((i >> j) & 1);
		return count;
	}
	/** 与えられたbit列の長さを返す */
	private int getBitLength(int i) {
		return (int)Math.ceil(Math.log(i + 0.5) / Math.log(2));
	}
	/** 仕事のスケジュールに重なりがあるかどうか */
	private boolean isNoSwamped(int combination, boolean[][] swamped) {
		for(int i = 0; i < getBitLength(combination); ++i) {
			if(((combination >> i) & 1) == 0) continue;
			for(int j = i + 1; j < Math.ceil(Math.log(combination) / Math.log(2)); ++j) {
				if(((combination >> j) & 1) == 0) continue;
				if(swamped[i][j]) return false;
			}
		}
		return true;
	}
	/** i番目とj番目が重なっているかどうかを計算し、配列に保存する */
 	private boolean[][] calcSwamped(List<Job> jobs) {
		boolean swamped[][] = new boolean[jobs.size()][jobs.size()];
		for(int i = 0; i < jobs.size(); ++i) {
			for(int j = i + 1; j < jobs.size(); ++j)
				swamped[i][j] = jobs.get(i).isSwamped(jobs.get(j));
		}
		return swamped;
	}
}
