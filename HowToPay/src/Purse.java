public class Purse {
	private final int count_of_500;
	private final int count_of_100;
	private final int count_of_050;
	private final int count_of_010;
	private final int count_of_005;
	private final int count_of_001;

	public static class Builder {
		private int count_of_500 = 0;
		private int count_of_100 = 0;
		private int count_of_050 = 0;
		private int count_of_010 = 0;
		private int count_of_005 = 0;
		private int count_of_001 = 0;

		public Builder countOf500(int count) {
			count_of_500 = count;
			return this;
		}

		public Builder countOf100(int count) {
			count_of_100 = count;
			return this;
		}

		public Builder countOf050(int count) {
			count_of_050 = count;
			return this;
		}

		public Builder countOf010(int count) {
			count_of_010 = count;
			return this;
		}

		public Builder countOf005(int count) {
			count_of_005 = count;
			return this;
		}

		public Builder countOf001(int count) {
			count_of_001 = count;
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
	}
}
