using System;

namespace ChessMetric
{
	public class ChessMetricSolver
	{
		struct Move {
			public int x, y;
			public Move(int x, int y) { this.x = x; this.y = y; }
		}

		long[ , , ] DP;
		Move[] moves = new Move[]{ new Move(-2, 1), new Move(2, 1), new Move(1, 2), new Move(1, -2), 
			new Move(2, -1), new Move(-2, -1), new Move(-1, -2), new Move(-1, 2),
			new Move(1, 1), new Move(1, -1), new Move(-1, -1), new Move(-1, 1),
			new Move(1, 0), new Move(0, -1), new Move(-1, 0), new Move(0, 1), 
		};

		public long solve(int size, int[] start, int[] end, int numMoves) {
			DP = new long[size, size, numMoves + 1];
			DP[start[0], start[1], 0] = 1;

			for(int step = 0; step < numMoves; ++step) {
				for(int x = 0; x < size; ++x) {
					for(int y = 0; y < size; ++y) {
						foreach(var move in moves) {
							if(canMove(size, x, y, move))
								DP[x + move.x, y + move.y, step + 1] += DP[x, y, step];
						}
					}
				}
			}
			return DP[end[0], end[1], numMoves];
		}

		private bool canMove(int size, int x, int y, Move move) {
			return canMove(size, x, move.x) && canMove(size, y, move.y);
		}

		private bool canMove(int size, int x, int move) {
			return 0 <= x + move && x + move < size;
		}
	}
}

