using System;

namespace ArrangeWidget
{
	class Solver2 {
		public IEnumerable<int> solve(String[] fields, Widget[] widgets) {
			Space[][] spaces = new Space[fields.Length][];
			for(int y = 0; y < spaces.Length; ++y) {
				spaces[y] = new Space[fields[y].Length];
				for(int x = 0; x < spaces[y].Length; ++x)
					spaces[y][x] = new Space(fields, x, y);
			}

			foreach(var widget in widgets)
				yield return solve(spaces, widget);
		}

		public int solve(Space[][] spaces, Widget widget) {
			return spaces.Select(spaceRaw => spaceRaw.Where(space => space.canArrange(widget)).Count()).Sum();
		}
	}
}

