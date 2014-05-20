using System;
using System.Collections.Generic;
using System.Linq;

namespace BlackJack
{
	public class Deck
	{
		IList<Card> cards = new List<Card>();

		public Deck()
		{
			for(int i = 0; i < 52; ++i)	cards.Add(new Card(i));
		}

		public void shuffle() {	cards = cards.OrderBy(card => Guid.NewGuid()).ToList(); }
		public int getCount() {	return cards.Count;	}
	}
}

