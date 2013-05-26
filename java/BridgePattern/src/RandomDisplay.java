import java.util.Random;


public class RandomDisplay extends Display {
	private Random rand;

	public RandomDisplay(DisplayImpl impl) {
		super(impl);
		rand = new Random();
	}

	void randomDisplay(int times) {
		for(int i = rand.nextInt(times); i >= 0; --i) {
			this.display();
		}
	}
}
