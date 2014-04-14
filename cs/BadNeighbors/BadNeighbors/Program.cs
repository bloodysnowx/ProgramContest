using System;

namespace BadNeighbors
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new BadNeighborsSolver();
			Console.WriteLine(solver.maxDonations(new int[]{10, 3, 2, 5, 7, 8}));
			Console.WriteLine(solver.maxDonations(new int[]{11, 15}));
			Console.WriteLine(solver.maxDonations(new int[]{7, 7, 7, 7, 7, 7, 7}));
			Console.WriteLine(solver.maxDonations(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
			Console.WriteLine(solver.maxDonations(new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 
				12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}));
		}
	}
}
