using System;
using System.Collections.Generic;
using System.Linq;

namespace BlackJack
{
	public class Hand
	{
		IList<Card> hand;

		public Hand(IList<Card> cards) {
			hand = new List<Card>(cards);
		}

		public void add(Card card) { hand.Add(card); }

		public int getValue() {
			int value = (from card in hand select card.getValue()).Sum();
			int aceCount = (from card in hand where card.getValue() == 1 select card).Count();
			if(aceCount > 0 && value < 12) value += 10;
			return value;
		}
	}
}

