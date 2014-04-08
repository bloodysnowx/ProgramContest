using System;

namespace CrazyBot
{
	public interface ICrazyBotSolver
	{
		Decimal solve(int n, int east, int west, int south, int north);
	}
}

