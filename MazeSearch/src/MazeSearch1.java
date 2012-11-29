public class MazeSearch1 implements MazeSearch {
	@Override
	public int search(MazePattern[][] maze) {
		printMaze(maze);
		initDistance(maze);
		findGoal(maze);
		for (int i = 0; i < Integer.MAX_VALUE; ++i) {
			if (findNeighbor(maze, i)) {
				return i + 1;
			}
		}

		return Integer.MAX_VALUE;
	}

	private int[][] distance;

	private void initDistance(MazePattern[][] maze) {
		distance = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[i].length; ++j) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private void findGoal(MazePattern[][] maze) {
		for (int i = 1; i < maze.length - 1; ++i) {
			for (int j = 1; j < maze[i].length - 1; ++j) {
				if (maze[i][j] == MazePattern.GOAL) {
					distance[i][j] = 0;
				}
			}
		}
	}

	private final int[] x_diff = { -1, 0, +1, 0 };
	private final int[] y_diff = { 0, +1, 0, -1 };

	private boolean findNeighbor(MazePattern[][] maze, int distance) {
		for (int i = 1; i < maze.length - 1; ++i) {
			for (int j = 1; j < maze[i].length - 1; ++j) {
				if (this.distance[i][j] == distance) {
					for (int k = 0; k < 4; ++k) {
						int x = i + x_diff[k];
						int y = j + y_diff[k];
						if (maze[x][y] == MazePattern.PASS
								&& this.distance[x][y] > distance) {
							this.distance[x][y] = distance + 1;
						} else if (maze[x][y] == MazePattern.START) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private void printMaze(MazePattern[][] maze) {
		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[i].length; ++j) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}

	}
}
