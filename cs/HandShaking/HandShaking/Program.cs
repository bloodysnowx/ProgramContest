using System;

/* DP[n] = DP[0] * DP[n - 2] + DP[2] * DP[n - 4] + DP[4] * DP[n - 6] + ... + DP[n - 4] * DP[2] + DP[n - 2] * DP[0] */
namespace HandShaking
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new HandShakingSolver();
			for(int i = 2; i < 51; i += 2)
				System.Console.WriteLine(solver.solve(i));
		}
	}
}
