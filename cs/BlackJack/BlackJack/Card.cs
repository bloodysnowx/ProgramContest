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
			System.Console.WriteLine(this.ToString());
		}

		public int getValue() { return Math.Min(10, rank); }

		public override string ToString()
		{
			return string.Format("[Card] {0} {1}", rank, suit);
		}
	}
}

