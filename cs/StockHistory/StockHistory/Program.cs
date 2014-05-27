/* 1. 最も値上がり率が高い月と株の組み合わせを探す
 * 2. そこで株を買う
 * 3. 次の月以降で最も値上がり率が高い月と株の組み合わせを探す
 * 4. そこで残っているお金で株を買う
 * 5. 最後の月に達するまで繰り返す */

using System;
using System.Linq;
using System.Collections.Generic;

namespace StockHistory
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new Solver();
			string[] stockPrices = { "10 20 30", "15 24 32" };
			System.Console.WriteLine(solver.maximumEarnings(1000, 0, stockPrices));
			stockPrices = new string[]{ "10", "9" };
			System.Console.WriteLine(solver.maximumEarnings(1000, 0, stockPrices));
			stockPrices = new string[]{ "40 50 60", "37 48 55", "100 48 50", "105 48 47", "110 50 52", "110 50 52", "110 51 54", "109 49 53" };
			System.Console.WriteLine(solver.maximumEarnings(100, 20, stockPrices));
		}
	}

	class Solver
	{
		public int maximumEarnings(int initialInvestment, int monthlyContribution, string[] stockPrices) {
			var stockPricesArray = from stockPrice in stockPrices select (from value in stockPrice.Split(' ') select System.Convert.ToDouble(value));
			return (int)Math.Round(maximumEarnings(initialInvestment, monthlyContribution, stockPricesArray));
		}

		public double maximumEarnings(int initialInvestment, int monthlyContribution, IEnumerable<IEnumerable<double>> stockPrices) {
			int periodOfMonth = stockPrices.Count() - 1;
			if(periodOfMonth == 0) return 0;
			var endPrices = stockPrices.Last();
			int maximumMonth = 0;
			int maximumStock = 0;
			double ratio = 1.0;
			for(int month = 0; month < periodOfMonth; ++month) {
				for(int stockNum = 0; stockNum < stockPrices.ElementAt(month).Count(); ++stockNum) {
					double currentRatio = endPrices.ElementAt(stockNum) / stockPrices.ElementAt(month).ElementAt(stockNum);
					if(ratio < currentRatio) {
						maximumMonth = month;
						maximumStock = stockNum;
						ratio = currentRatio;
					}
				}
			}

			int money = initialInvestment + maximumMonth * monthlyContribution;
			double earnings = money * (ratio - 1.0);

			return earnings + maximumEarnings(monthlyContribution, monthlyContribution, stockPrices.Skip(maximumMonth + 1));
		}
	}
}
