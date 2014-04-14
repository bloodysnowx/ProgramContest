using System;
using System.Linq;
using System.Collections.Generic;

/* 1. 最初(0)を選んだ場合、最後(N)を除外する
 * 2. 最後(N)を選んだ場合、最初(0)を除外する
 * 3. 除外した後の数列を直線と考えて処理する(0...n)
 * 4. 最初に最後(n)を選んだ場合の最大値を計算する -> 最後のみ(d(n))
 * 5. 最初に最後の1つ前(n-1)を選んだ場合の最大値を計算する -> 最後の1つ前のみ(d(n-1))
 * 6. 最初に最後の2つ前(n-2)を選んだ場合の最大値を計算する -> 最後の2つ前(d(n-2)) + 最後(d(n))
 * 7. 最初に最後の3つ前を選んだ場合の最大値を計算する -> 最後の3つ前(d(n-3)) + Max(d(n-1), d(n))
 * 8. ...
 * 9. 最初に最初の1つ後を選んだ場合の最大値を計算する ->
 * 10. 最初に最初を選んだ場合の最大値を計算する ->
 * 11. 最初と最後のどちらかを取り除いたもののうち最大を返す */

namespace BadNeighbors
{
	public class BadNeighborsSolver
	{
		public int maxDonations(int[] donations) {
			return Math.Max(maxDonationSub(donations.Skip(1).ToArray()), maxDonationSub(donations.Take(donations.Length - 1).ToArray()));
		}

		private int maxDonationSub(int[] donations) {
			int[] maxDonations = new int[donations.Count()];
			maxDonations[0] = donations[0];
			if(donations.Count() > 1) maxDonations[1] = Math.Max(donations[0], donations[1]);
			for(int i = 2; i < donations.Count(); ++i) {
				maxDonations[i] = Math.Max(maxDonations[i - 1], maxDonations[i - 2] + donations[i]);
			}

			return maxDonations.Last();
		}
	}
}
