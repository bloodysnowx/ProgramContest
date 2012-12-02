
public class HowToPay1 implements HowToPay {
	private int sum;
	private int remainder;
	
	@Override
	public int payWithCoins(int[] values, int[] nums, int money) {
		sum = 0;
		remainder = money;
		for(int i = 0; i < values.length; ++i)
		{
			payWith(values[i], nums[i]);
		}
		
		return sum;
	}
	
	private void payWith(int value, int num)
	{
		int count = Math.min(remainder / value, num);
		sum += count;
		remainder -= count * value;
	}
}
