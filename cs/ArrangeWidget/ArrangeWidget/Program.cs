using System;
using System.Collections.Generic;

namespace ArrangeWidget
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			readFromConsole();
			/*
			var solver = new Solver();
			var answers = solver.solve(new string[]{"1000", "1101", "1001"}, new Widget[]{new Widget(1, 2), new Widget(2, 3), new Widget(2, 1)});
			foreach(int answer in answers)
				System.Console.WriteLine(answer);
			*/
		}

		private static void readFromConsole() {
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

			var answers = (new Solver()).solve(fields, widgets);
			foreach(int answer in answers)
				System.Console.WriteLine(answer); 
		}

		class Widget {
			public int S { get; private set; }
			public int T { get; private set; }

			public Widget(int S, int T) {
				this.S = S - 1;
				this.T = T - 1;
			}
		}

		class Space {
			private int[] widthList;

			public Space(String[] fields, int x, int y) {

			}

			public bool canArrange(Widget widget) {
				return true;
			}
		}

		class Solver {
			public IEnumerable<int> solve(String[] fields, Widget[] widgets) {
				foreach(Widget widget in widgets)
					yield return solve(fields, widget);
			}

			private int solve(String[] fields, Widget widget) {
				int answer = 0;
				for(int i = 0; i < fields.Length - widget.S; ++i) {
					for(int j = 0; j < fields[i].Length - widget.T; ++j) {
						if(canArrange(fields, widget, i, j)) {
							++answer;
						}
					}
				}
				return answer;
			}

			private bool canArrange(String[] fields, Widget widget, int i, int j) {
				bool result = true;
				for(int x = j; x <= j + widget.T; ++x) {
					for(int y = i; y <= i + widget.S; ++y) {
						// System.Console.Write("(" + y.ToString() + ", " + x.ToString() + "), ");
						result = result && fields[y][x] == '0';
					}
				}
				// System.Console.WriteLine("canArray(" + i.ToString() + ", " + j.ToString() + ") = " + result.ToString());
				return result;
			}
		}
	}
}
