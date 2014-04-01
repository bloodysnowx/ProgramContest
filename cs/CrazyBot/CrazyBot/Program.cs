using System;

namespace CrazyBot
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new CrazyBotSolver();
			Console.WriteLine(solver.solve(1, 25, 25, 25, 25));
			Console.WriteLine(solver.solve(2, 25, 25, 25, 25));
			Console.WriteLine(solver.solve(7, 50, 0, 0, 50));
			Console.WriteLine(solver.solve(14, 50, 50, 0, 0));
			Console.WriteLine(solver.solve(14, 25, 25, 25, 25));
		}
	}
}
