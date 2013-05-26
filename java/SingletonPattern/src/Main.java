
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start");
		for(int i = 0; i < 10; ++i) {
			System.out.println(i + ":" + TicketMaker.INSTANCE.getNextTicketNumber());
		}
		System.out.println("end");
		
		System.out.println("start");
		for(int i = 0; i < 10; ++i) {
			System.out.println(i + ":" + TripleInstance.values()[i % 3]);
		}
		System.out.println("end");
	}
}
