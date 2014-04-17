using System;
using System.Collections.Generic;
using System.Linq;

namespace ArrangeWidget
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			readFromConsole();
			// readFromSource();
		}

		private static void readFromSource() {
			var solver = new Solver2();
			var answers = solver.solve(new string[]{"1000", "1101", "1001", "1111"}, new Widget[]{new Widget(1, 2), new Widget(2, 3), new Widget(2, 1)});
			foreach(int answer in answers)
				System.Console.WriteLine(answer);
		}

		private static void readFromConsole() {
			var solver = new Solver2();
			var line1 = System.Console.ReadLine().Trim().Split(' ');
			var H = Int32.Parse(line1[0]);
			var W = Int32.Parse(line1[1]);
			var fields = new String[H];
			for (var i = 0; i < H; ++i) {
				var line = System.Console.ReadLine().Trim();
				fields[i] = line;
			}
			var line2 = System.Console.ReadLine().Trim();
			var N = Int32.Parse(line2);
			var widgets = new Widget[N];
			for(var i = 0; i < N; ++i) {
				var line = System.Console.ReadLine().Trim().Split(' ');
				var S = Int32.Parse(line[0]);
				var T = Int32.Parse(line[1]);
				widgets[i] = new Widget(S, T);
			}

			var answers = solver.solve(fields, widgets);
			foreach(int answer in answers)
				System.Console.WriteLine(answer); 
		}


	}
}
