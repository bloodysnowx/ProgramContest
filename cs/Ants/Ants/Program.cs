using System;
using System.Collections.Generic;
using System.Linq;

namespace Ants
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			
		}
	}

	class Solver
	{
		private int length;
		private IList<int> ants;

		Solver(int length, IList<int> ants) {
			this.length = length;
			this.ants = ants;
		}

		int getMin() { return ants.Select (x => Math.Min (x, length - x)).Max; }
		int getMax() { return ants.Select (x => Math.Max (x, length - x)).Max; }
	}
}
