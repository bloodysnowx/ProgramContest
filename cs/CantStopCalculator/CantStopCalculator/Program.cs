using System;

namespace CantStopCalculator
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var cantStopCalculator = new CantStopCalculator();
			/*
			for(uint i = 2; i < 13; ++i) {
				System.Console.WriteLine("Calc start, i = " + i);
				System.Console.WriteLine("Combinations = " + cantStopCalculator.getCombination(i));
			}

			for(uint i = 2; i < 13; ++i) {
				System.Console.WriteLine("Calc start, i = " + i);
				for(uint j = 2; j < 13; ++j) {
					System.Console.Write(cantStopCalculator.getCombination(i, j) + " ");
				}
				System.Console.WriteLine();
			}
			*/

			uint[] targets = new uint[args.Length - 1];
			for(int i = 0; i < targets.Length; ++i)
				targets[i] = System.Convert.ToUInt32(args[i + 1]);
			var combinations = cantStopCalculator.getCombination(targets);
			Console.WriteLine("Combinations = " + combinations);
			Console.WriteLine("Probability = " + (double)combinations / (double)cantStopCalculator.getAllCombination());

			Console.ReadLine();
		}
	}

	class CantStopCalculator {
		public uint getAllCombination() { return 6 * 6 * 6 * 6; }
		public uint getCombination(uint target) {
			uint count = 0;
			for(uint i = 0; i < getAllCombination(); ++i) if(isOK(getDices(i), target)) ++count;
			return count;
		}

		public uint getCombination(uint targetA, uint targetB) {
			uint count = 0;
			for(uint i = 0; i < getAllCombination(); ++i) if(isOK(getDices(i), targetA) || isOK(getDices(i), targetB)) ++count;
			return count;
		}

		public uint getCombination(uint[] targets) {
			uint count = 0;
			for(uint i = 0; i < getAllCombination(); ++i) foreach(var target in targets) if(isOK(getDices(i), target)) {
						++count;
						break;
			}
			return count;
		}

		private uint[] getDices(uint i) {
			uint[] quotients = new uint[4];
			uint[] remainders = new uint[4];
			quotients[0] = i / 6;
			remainders[0] = (i % 6) + 1;
			for(int j = 1; j < 4; ++j) {
				quotients[j] = quotients[j - 1] / 6;
				remainders[j] = (quotients[j - 1] % 6) + 1;
			}
			return remainders;
		}

		private bool isOK(uint[] dices, uint target) {
			for(int i = 0; i < 3; ++i) for(int j = i + 1; j < 4; ++j) if(dices[i] + dices[j] == target) return true;
			return false;
		}
	}
}
