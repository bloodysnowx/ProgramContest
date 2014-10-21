using System;
using System.Collections.Generic;
using System.Linq;

namespace MazeShortestLine
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			var maze = new string[] {
				"#S######.#",
				"......#..#",
				".#.##.##.#",
				".#........",
				"##.##.####",
				"....#....#",
				".#######.#",
				"....#.....",
				".####.###.",
				"....#...G#",
			};
			var solver = new MazeShortesLineFinder(maze);
			System.Console.WriteLine(solver.solve());
		}
	}

	struct Point {
		public int X { get; private set; }
		public int Y { get; private set; }
		public Point(int x, int y):this() { X = x; Y = y; }
		public Boolean isEqual(int x, int y) { return x == X && y == Y; }
	}

	/* 1. startを探す
	 * 2. startに0を記入する
	 * 3. startから1歩でたどり着ける点に1を記入する
	 * 4. 1歩の地点から1歩でたどり着ける点に2を記入する
	 * 5. 2歩お地点から・・・
	 * 6. goalにたどりついたら、その数値を出力する
	 */
	class MazeShortesLineFinder {
		private string[] maze;
		public Point Start { get; private set; }
		public Point Goal { get; private set; }
		private List<List<int>> distances = new List<List<int>>();

		public MazeShortesLineFinder(string[] maze) {
			this.maze = maze;
			Start = findStart();
			Goal = findGoal();
			distances = maze.Select(line => line.Select(x => -1).ToList()).ToList();
		}

		private Point findStart() { return findChar('S'); }
		private Point findGoal() { return findChar('G'); }
		private Point findChar(char c) { for(int i = 0; i < maze.Length; ++i) if(maze[i].Contains(c.ToString())) return new Point(i, maze[i].IndexOf(c)); throw new ArgumentException(); }
		private Boolean canMove(int x, int y) { return -1 < x && x < maze.Length && -1 < y && y < maze[0].Length && maze[x][y] != '#'; }
		private Boolean isStart(int x, int y) { return Start.isEqual(x, y); }
		private Boolean isGoal(int x, int y) { return Goal.isEqual(x, y); }
		private Boolean isVisited(int x, int y) { return distances[x][y] > -1; }

		public int solve() {
			var queue = new Queue<Point>();
			queue.Enqueue(Start);
			distances[Start.X][Start.Y] = 0;

			int[][] destinations = new int[][]{ new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0} };

			while(queue.Count > 0) {
				Point currentPoint = queue.Dequeue();
				int currentDistance = distances[currentPoint.X][currentPoint.Y];
				int nextDistance = currentDistance + 1;

				foreach(var dest in destinations) {
					Point nextPoint = new Point(currentPoint.X + dest[0], currentPoint.Y + dest[1]);
					if(isGoal(nextPoint.X, nextPoint.Y)) return nextDistance;
					if(canMove(nextPoint.X, nextPoint.Y) && !isVisited(nextPoint.X, nextPoint.Y)) {
						distances[nextPoint.X][nextPoint.Y] = nextDistance;
						queue.Enqueue(nextPoint);
					}
				}
			}

			return -1;
		}
	}
}
