/* 1. 利子0で計算する
 * 2. 利子x(100)で計算する
 * 3. 結果が間であれば、利子x/2で計算する(0未満と100以上は考えないので、0未満は0を、100以上は100を出力して終了する)
 * 4. 結果がx/2より大きければ、3/4 * xで計算する
 * 5. 結果がx/2より小さければ、1/4 * xで計算する
 * 6. 以下二分探索を繰り返す */

using System;

namespace AutoLoan
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var solver = new AutoLoanSolver();
			Console.WriteLine(solver.solve(6800, 100, 68));
			Console.WriteLine(solver.solve(2000, 510, 4));
			Console.WriteLine(solver.solve(15000, 364, 48));
		}
	}

    class AutoLoanSolver
    {
		class Values {
			public Values(double price, double annualInterest) {
				Price = price;
				AnnualInterest = annualInterest;
			}
			public double Price { get; set; }
			public double AnnualInterest { get; set; }
		}

        public double solve(int price, int monthlyPayment, int loanTerm) {
			Values minValues = calcValues(0.0, monthlyPayment, loanTerm);
			Values maxValues = calcValues(100.0, monthlyPayment, loanTerm);
			if(minValues.Price < price) return minValues.AnnualInterest;
			if(maxValues.Price > price) return maxValues.AnnualInterest;
			while(true) {
				Values midValues = calcValues((minValues.AnnualInterest + maxValues.AnnualInterest) / 2.0, monthlyPayment, loanTerm);
				if(Math.Abs(midValues.Price - price) < 1.0E-9) return midValues.AnnualInterest;
				if(midValues.Price > price) minValues = midValues;
				else maxValues = midValues;
			}
        }

		private Values calcValues(double annualInterest, int monthlyPayment, int loanTerm) {
			return new Values(calc(annualInterest, monthlyPayment, loanTerm), annualInterest);
		}

		private double calc(double annualInterest, int monthlyPayment, int loanTerm) {
			double paid = 0.0;
			for(int i = 0; i < loanTerm; ++i) {
				paid += monthlyPayment * 100.0 / (100.0 + annualInterest / 12.0) - paid * annualInterest / 100.0 / 12.0;
			}
			return paid;
        }
    }
}
