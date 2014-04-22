using System;

/* 1. 1歩で来られるパターン数を各マスに記載する(ex. 0 or 1)
 * 2. 2歩で来られるパターン数を各マスに記載する(ex. 0, 1, 2, ..., )
 * 3. ...
 * 4. N歩で来られるパターン数を各マスに記載する
 * 5. Goalのパターン数を出力する
 * 
 * DP[x, y, i] = DP[x - ?, y - ?, i - 1] + DP[x - ?, y - ?, i - 1] + ... + DP[x - ?, y - ?, i - 1]
 */

namespace ChessMetric
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new ChessMetricSolver();
			System.Console.WriteLine(solver.solve(3, new int[]{ 0, 0 }, new int[]{ 1, 0 }, 1));
			System.Console.WriteLine(solver.solve(3, new int[]{ 0, 0 }, new int[]{ 1, 2 }, 1));
			System.Console.WriteLine(solver.solve(3, new int[]{ 0, 0 }, new int[]{ 2, 2 }, 1));
			System.Console.WriteLine(solver.solve(3, new int[]{ 0, 0 }, new int[]{ 0, 0 }, 2));
			System.Console.WriteLine(solver.solve(100, new int[]{ 0, 0 }, new int[]{ 0, 99 }, 50));
		}
	}
}
