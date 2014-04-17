using System;
using System.Collections.Generic;

namespace ArrangeWidget
{
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

