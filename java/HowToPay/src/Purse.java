public class Purse {
	private final int count_of_500;
	private final int count_of_100;
	private final int count_of_050;
	private final int count_of_010;
	private final int count_of_005;
	private final int count_of_001;
	private final HowToPay payment;

	public static class Builder {
		private int count_of_500 = 0;
		private int count_of_100 = 0;
		private int count_of_050 = 0;
		private int count_of_010 = 0;
		private int count_of_005 = 0;
		private int count_of_001 = 0;
		private HowToPay payment = null;

		public Builder co500(int count) {
			count_of_500 = count;
			return this;
		}

		public Builder co100(int count) {
			count_of_100 = count;
			return this;
		}

		public Builder co050(int count) {
			count_of_050 = count;
			return this;
		}

		public Builder co010(int count) {
			count_of_010 = count;
			return this;
		}

		public Builder co005(int count) {
			count_of_005 = count;
			return this;
		}

		public Builder co001(int count) {
			count_of_001 = count;
			return this;
		}

		public Builder payment(HowToPay payment) {
			this.payment = payment;
			return this;
		}

		public Purse build() {
			return new Purse(this);
		}
	}

	private Purse(Builder builder) {
		count_of_500 = builder.count_of_500;
		count_of_100 = builder.count_of_100;
		count_of_050 = builder.count_of_050;
		count_of_010 = builder.count_of_010;
		count_of_005 = builder.count_of_005;
		count_of_001 = builder.count_of_001;
		payment = builder.payment;
	}

	public int pay(int money) {
		final int values[] = { 500, 100, 50, 10, 5, 1 };
		final int nums[] = { count_of_500, count_of_100, count_of_050,
				count_of_010, count_of_005, count_of_001 };

		return payment.payWithCoins(values, nums, money);
	}
}
