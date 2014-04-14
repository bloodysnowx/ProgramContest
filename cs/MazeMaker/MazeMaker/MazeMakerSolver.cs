using System;
using System.Linq;
using System.Collections.Generic;
using System.Drawing;

/* 1. Start地点に0を書く
 * 2. 0から移動できるところに1を書く(既に数字が書いてあれば書かない)
 * 3. 1から移動できるところに2を書く(既に数字が書いてあれば書かない)
 * 4. ...
 * 5. 書けなくなった時点で終了する
 * 6. 書けなくなっても訪ずれていない点があった場合は-1を、無かった場合は最大値を返す */

namespace MazeMaker
{
	public class MazeMakerSolver
	{
		private const int OBSTACLE = -2;
		private const char OBSTACLE_CHAR = 'X';
		private const int NOT_VISITED = -1;
		private int[][] mazeStepsFromStart;

		public int solve(string[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
			initMazeStepsFromStart(maze);
			mazeStepsFromStart[startRow][startCol] = 0;
			var moves = Enumerable.Zip(moveCol, moveRow, (x, y) => new Point(x, y));

			for(int n = 0; mazeStepsFromStart.Any(x => x.Any(y => y == n)) ; ++n) {
				foreach(Point p in findSteps(n)) {
					foreach(var move in moves)
					{
						var dest_x = p.X + move.X;
						var dest_y = p.Y + move.Y;
						if(canMove(dest_x, dest_y, maze) && mazeStepsFromStart[dest_y][dest_x] == NOT_VISITED)
							mazeStepsFromStart[dest_y][dest_x] = n + 1;
					}
				}
			}
			
			if(mazeStepsFromStart.Any(x => x.Any(y => y == NOT_VISITED))) return NOT_VISITED;
			return mazeStepsFromStart.Max(x => x.Max(y => y));
		}

		private IEnumerable<Point> findSteps(int n) {
			for(int i = 0; i < mazeStepsFromStart.Length; ++i)
				for(int j = 0; j < mazeStepsFromStart[i].Length; ++j)
					if(mazeStepsFromStart[i][j] == n)
						yield return new Point(j, i);
		}

		private void initMazeStepsFromStart(string[] maze) {
			mazeStepsFromStart = new int[maze.Length][];
			for(int i = 0; i < maze.Length; ++i) {
				mazeStepsFromStart[i] = new int[maze[i].Length];
				for(int j = 0; j < maze[i].Length; ++j) mazeStepsFromStart[i][j] = (maze[i][j] == OBSTACLE_CHAR ? OBSTACLE : NOT_VISITED);
			}
		}

		private Boolean canMove(int dest_x, int dest_y, string[] maze) {
			return 0 <= dest_x && dest_x < maze[0].Length && 0 <= dest_y && dest_y < maze.Length;
		}
	}
}

