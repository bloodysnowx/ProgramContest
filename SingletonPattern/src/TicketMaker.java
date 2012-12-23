
public enum TicketMaker {
	INSTANCE;
	private int ticket = 1000;
	public synchronized int getNextTicketNumber() {
		return ticket++;
	}
}
