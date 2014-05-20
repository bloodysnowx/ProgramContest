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
		public Card getFaceCard() { return hand[0]; }

		public int getValue() {
			int value = (from card in hand select card.getValue()).Sum();
			int aceCount = (from card in hand where card.getValue() == 1 select card).Count();
			if(aceCount > 0 && value < 12) value += 10;
			return value;
		}

		public override string ToString() {
			return String.Join(", ", from card in hand select card.ToString());
		}

		public Boolean isBlackJack() {
			return hand.Count == 2 && getValue() == 21;
		}

		public Boolean isBursted() {
			return getValue() > 21;
		}
	}
}

