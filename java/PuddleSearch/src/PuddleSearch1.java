public class PuddleSearch1 implements PuddleSearch {

	// 水たまりマップから水たまりの数をカウントする
	public int search(int[][] puddle) {
		int[][] counted_puddle = new int[puddle.length][puddle[0].length];

		for (int i = 1; i < puddle.length - 1; ++i) {
			for (int j = 1; j < puddle[i].length - 1; ++j) {
				counted_puddle[i][j] = count(i, j, puddle);
			}
		}

		for (int[] column : counted_puddle) {
			for (int x : column) {
				System.out.print(x);
			}
			System.out.println("");
		}
		return 0;
	}

	// 水たまりマップ内の水たまりを凝縮する
	private int[][] reduce(int[][] puddle) {
		for (int i = 0; i < puddle.length; ++i) {
			for (int j = 0; j < puddle[i].length; ++j) {
				if (puddle[i][j] > 0) {

				}
			}
		}
		return puddle;
	}

	// 指定したポイントを中心とした9マスに存在する水の数をカウントする
	private int count(int x, int y, int[][] puddle) {
		int count = 0;
		if (puddle[x][y] > 0) {
			for (int i = x - 1; i <= x + 1; ++i) {
				for (int j = y - 1; j <= y + 1; ++j) {
					if (puddle[i][j] > 0)
						count++;
				}
			}
		}

		return count;
	}

	// すべての水たまりが凝縮し終わるまでreduceする
	private int[][] reduceAll(int[][] puddle) {
		return puddle;
	}
}
