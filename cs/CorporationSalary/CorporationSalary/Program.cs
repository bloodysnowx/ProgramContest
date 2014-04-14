using System;

namespace CorporationSalary
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new CorporationSalarySolver();
			String[] relations = { "N" };
			Console.WriteLine(solver.solve(relations));
			relations = new string[] {"NNYN", "NNYN", "NNNN", "NYYN"};
			Console.WriteLine(solver.solve(relations));
			relations = new string[] {"NNNNNN", "YNYNNY", "YNNNNY", "NNNNNN", "YNYNNN", "YNNYNN" };
			Console.WriteLine(solver.solve(relations));
			relations = new string[] {"NYNNYN", "NNNNNN", "NNNNNN", "NNYNNN", "NNNNNN", "NNNYYN"};
			Console.WriteLine(solver.solve(relations));
			relations = new string[]{"NNNN", "NNNN", "NNNN", "NNNN"};
			Console.WriteLine(solver.solve(relations));
		}
	}
}
