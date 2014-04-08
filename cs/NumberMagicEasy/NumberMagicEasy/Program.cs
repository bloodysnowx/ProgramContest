using System;

namespace NumberMagicEasy
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new NumberMagicEasySolver();
			Console.WriteLine(solver.solve("YNYY"));
			Console.WriteLine(solver.solve("YNNN"));
			Console.WriteLine(solver.solve("NNNN"));
			Console.WriteLine(solver.solve("YYYY"));
			Console.WriteLine(solver.solve("NYNY"));
		}
	}
}
