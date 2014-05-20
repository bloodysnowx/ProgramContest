using System;

namespace BlackJack
{
	public class Card
	{
		enum Suit {
			Spades = 0, Hearts, Diamonds, Clubs
		}

		Suit suit;
		int rank;

		public Card(int i)
		{
			if(i < 0 || 51 < i)
				throw new ArgumentOutOfRangeException();

			rank = (i % 13) + 1;
			suit = (Suit)(i / 13);
		}

		public int getValue() { return Math.Min(10, rank); }
	}
}

