using System;
using System.Linq;

namespace CantStopCalculator
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			uint[] targets = new uint[args.Length];
			for(int i = 0; i < targets.Length; ++i) targets[i] = System.Convert.ToUInt32(args[i]);

			var cantStopCalculator = new CantStopCalculator(targets);
			Console.WriteLine("Combinations = " + cantStopCalculator.getCombination());
			Console.WriteLine("Probability = " + cantStopCalculator.getProbability());
			Console.WriteLine("ShoudWalkSteps = " + cantStopCalculator.getShouldWalkSteps());
			Console.ReadLine();
		}
	}

	class CantStopCalculator {
		uint[] targets;
		int combination = -1;

		public CantStopCalculator(uint[] targets) { this.targets = targets; }

		public uint getAllCombination() { return 6 * 6 * 6 * 6; }

		public uint getCombination() {
			if(combination >= 0) return (uint)combination;
			combination = 0;
			for(uint i = 0; i < getAllCombination(); ++i) foreach(var target in targets) if(isOK(getDices(i), target)) { ++combination; break; }
			return (uint)combination;
		}

		public double getProbability() { return (double)getCombination() / (double)getAllCombination(); }

		public uint getShouldWalkSteps() {
			uint i = 0;
			for(i = 0; i < 100; ++i) if(!shoudWalk(i)) break;
			return i - 1;
		}

		public bool shoudWalk(uint steps) { return (getProbability() * 1 - (1 - getProbability()) * steps) > 0; }

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
