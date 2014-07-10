using System;
using System.Linq;

namespace Sort
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var sorter = new SelectionSort();
			int[] input = { 5, 8, 3, 2, 4, 1 };
			Console.WriteLine("input is " + string.Join(", ", input.Select(x => x.ToString())));
			int[] output = sorter.sort(input);
			Console.WriteLine("output is " + string.Join(", ", output.Select(x => x.ToString())));
		}
	}

	class SelectionSort
	{
		public int[] sort(int[] input) {
			for(int i = 0; i < input.Length; ++i) {
				var min_order = i;
				for(int j = i + 1; j < input.Length; ++j) if(input[min_order] > input[j]) min_order = j;
				var min = input[min_order];
				input[min_order] = input[i];
				input[i] = min;
			}
			return input;
		}
	}
}
