using System;

namespace ArrangeWidget
{
	class Widget {
		public int S { get; private set; }
		public int T { get; private set; }

		public Widget(int S, int T) {
			this.S = S - 1;
			this.T = T - 1;
		}
	}
}

