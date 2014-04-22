using System;

namespace HandShaking
{
	public class HandShakingSolver
	{
		public long solve(int n)
		{
			if(n % 2 == 1) return 0;
			if(n == 2) return 1;
			if(n == 4) return 2;

			long[] DP = new long[n + 1];
			DP[0] = 1;
			DP[2] = 1;
			DP[4] = 2;
			for(int i = 6; i <= n; i += 2) {
				for(int j = 1; j < i; j += 2) {
					DP[i] += DP[j - 1] * DP[i - j - 1];
				}
			}

			return DP[n];
		}
	}
}