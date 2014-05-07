using System;

/* 1. onlyRed + onlyBlue と bothColors * 2 を比較する
 * 2. 前者が大きければ前者メインに、後者が大きければ後者メインで */
namespace ColorfulBoxesAndBalls
{
	class Solver {
		public int solve(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
			var numBoth = (onlyRed + onlyBlue >= bothColors * 2) ? 0 : Math.Min(numRed, numBlue);
			return numBoth * bothColors * 2 + (numRed - numBoth) * onlyRed + (numBlue - numBoth) * onlyBlue;
		}
	}

	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new Solver();
			Console.WriteLine(solver.solve(2, 3, 100, 400, 200));
			Console.WriteLine(solver.solve(2, 3, 100, 400, 300));
			Console.WriteLine(solver.solve(5, 5, 464, 464, 464));
			Console.WriteLine(solver.solve(1, 4, 20, -30, -10));
			Console.WriteLine(solver.solve(9, 1, -1, -10, 4));

		}
	}
}
