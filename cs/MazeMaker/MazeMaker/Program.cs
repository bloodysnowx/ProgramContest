using System;

namespace MazeMaker
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new MazeMakerSolver();
			string[] maze = { "...", "...", "..." };
			int[] moveRow = { 1, 0, -1, 0 };
			int[] moveCol = { 0, 1, 0, -1 };
			Console.WriteLine(solver.solve(maze, 0, 1, moveRow, moveCol));

			maze = new string[]{ "...", "...", "..." };
			moveRow = new int[]{ 1, 0, -1, 0, 1, 1, -1, -1 };
			moveCol = new int[]{ 0, 1, 0, -1, 1, -1, 1, -1 };
			Console.WriteLine(solver.solve(maze, 0, 1, moveRow, moveCol));

			maze = new string[]{ "X.X", "...", "XXX", "X.X" };
			moveRow = new int[]{1, 0, -1, 0};
			moveCol = new int[]{0, 1, 0, -1};
			Console.WriteLine(solver.solve(maze, 0, 1, moveRow, moveCol));

			maze = new string[]{ ".......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......." };
			moveRow = new int[]{ 1, 0, -1, 0, -2, 1 };
			moveCol = new int[]{ 0, -1, 0, 1, 3, 0 };
			Console.WriteLine(solver.solve(maze, 5, 0, moveRow, moveCol));

			maze = new string[]{ "......." };
			moveRow = new int[]{ 1, 0, 1, 0, 1, 0 };
			moveCol = new int[]{ 0, 1, 0, 1, 0, 1 };
			Console.WriteLine(solver.solve(maze, 0, 0, moveRow, moveCol));

			maze = new string[]{ "..X.X.X.X.X.X." };
			moveRow = new int[]{ 2, 0, -2, 0 };
			moveCol = new int[]{ 0, 2, 0, -2 };
			Console.WriteLine(solver.solve(maze, 0, 0, moveRow, moveCol));
		}
	}
}
