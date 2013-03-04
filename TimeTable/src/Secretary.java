/** タイムテーブルを管理し、最適な仕事を出力する */
public class Secretary {
	private final Timetable timetable;
	private final HowToChoose choose;

	public Secretary(Timetable timetable, HowToChoose choose) {
		this.timetable = timetable;
		this.choose = choose;
	}

	public Timetable getBestSuitedTimetable() {
		return choose.calcMostSuitedTimetable(timetable);
	}
}
