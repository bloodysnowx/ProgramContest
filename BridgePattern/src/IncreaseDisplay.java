
public class IncreaseDisplay extends CountDisplay {

	public IncreaseDisplay(DisplayImpl impl) {
		super(impl);
		// TODO Auto-generated constructor stub
	}
	
	public void increaseDisplay(int count)
	{
		for(int i = 0; i < count; ++i)
		{
			this.multiDisplay(i);
		}
	}
}
