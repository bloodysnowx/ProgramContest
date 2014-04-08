using System;

namespace NumberMagicEasy
{
	public class NumberMagicEasySolver
	{
		public int solve(string answer) {
			int number = 1;
			for(int i = 0; i < 4; ++i) number += answer[3 - i] == 'N' ? 1 << i : 0;
			return number;
		}
	}
}

