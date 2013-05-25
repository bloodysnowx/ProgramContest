import framework.*;
import idcard.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("player1");
		Product card2 = factory.create("player2");
		Product card3 = factory.create("player3");
		card1.use();
		card2.use();
		card3.use();
		
		factory = new IDCardWithSerialFactory();
		Product card0 = factory.create("player0");
		card1 = factory.create("player1");
		card2 = factory.create("player2");
		card3 = factory.create("player3");
		((IDCardWithSerialFactory)factory).printList();
	}

}
