using System;
using System.Linq;
using System.Collections.Generic;

namespace LakeCounting
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			var solver = new LakeCounter (new string[]{ "W" });
			Console.WriteLine (solver.count ());
			solver = new LakeCounter (new string[]{ 
				"W........WW.",
				".WWW.....WWW",
				"....WW...WW.",
				".........WW.",
				".........W..",
				".........W..",
				"..W......W..",
				".W.W.....WW.",
				"W.W.W.....W.",
				".W.W......W.",
				"..W.......W."});
			Console.WriteLine (solver.count ());

			solver = new LakeCounter (new string[]{ 
				"W........WW.",
				".W.W.....WWW",
				"....WW...WW.",
				".........WW.",
				".........W..",
				".........W..",
				"..W.........",
				".W.W.....WW.",
				"W.W.W.....W.",
				".W.W......W.",
				"..W.......W."});
			Console.WriteLine (solver.count ());
		}
	}

	/*
	 * 1. 
	 * 2. 
	 * 3. 
     */

	class LakeCounter
	{
		private List<List<int>> lakeMap;

		public LakeCounter(IEnumerable<string> map)
		{
			lakeMap = map.Select(line => line.Select (c => c == 'W' ? -1 : 0).ToList()).ToList();
		}

		public int count()
		{
			while (isCountCompleted () == false) findLakeAndConvert ();
			return getMax ();
		}

		private int getMax() { return Math.Max(lakeMap.Max (line => line.Max ()), 0); }

		private void findLakeAndConvert() {
			int number = getMax () + 1;
			for (int i = 0; i < lakeMap.Count; ++i) {
				for (int j = 0; j < lakeMap[i].Count; ++j) {
					if (lakeMap[i][j] == -1) {
						flip (i, j, number);
						return;
					}
				}
			}
		}

		private void flip(int x, int y, int number) {
			lakeMap [x][y] = number;
			for (int i = Math.Max (0, x - 1); i < Math.Min (x + 2, lakeMap.Count); ++i) {
				for (int j = Math.Max (0, y - 1); j < Math.Min (y + 2, lakeMap[i].Count); ++j) {
					if (lakeMap[i][j] == -1) flip (i, j, number);
				}
			}
		}

		private bool isCountCompleted() {
			return lakeMap.All(line => line.All(c => c >= 0));
		}
	}
}
