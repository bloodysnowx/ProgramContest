public class PuddleSearch2 implements PuddleSearch {

	@Override
	public int search(int[][] puddle) {
		int count = 0;
		while (reduce(puddle)) {
			printPuddle(puddle);
			++count;
		}
		return count;
	}

	private boolean reduce(int[][] puddle) {
		for (int i = 1; i < puddle.length - 1; ++i) {
			for (int j = 1; j < puddle[i].length - 1; ++j) {
				if (puddle[i][j] > 0) {
					reduceOne(i, j, puddle);
					return true;
				}
			}
		}
		return false;
	}

	private void reduceOne(int x, int y, int[][] puddle) {
		if (puddle[x][y] == 0)
			return;
		puddle[x][y] = 0;
		for (int i = x - 1; i <= x + 1; ++i) {
			for (int j = y - 1; j <= y + 1; ++j)
				reduceOne(i, j, puddle);
		}

	}

	private void printPuddle(int[][] puddle) {
		for (int[] line : puddle) {
			for (int x : line) {
				System.out.print(x);
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
