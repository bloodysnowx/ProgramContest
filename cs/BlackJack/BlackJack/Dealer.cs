using System;
using System.Collections.Generic;

namespace BlackJack
{
	public class Dealer
	{
		Hand hand;
		Deck deck = new Deck();

		public Dealer()
		{
		}

		public Card hit() {	return deck.popCard(); }
		public void shuffle() { deck.shuffle(); }
		public void init() { hand = new Hand(new List<Card>(){ deck.popCard(), deck.popCard() }); }
		public Card getFaceCard() { return hand.getFaceCard(); }
		public void start() {
			Console.WriteLine("Dealar's Hand is : " + hand);
			Console.WriteLine("Dealar's Value is : " + hand.getValue());
			while(hand.getValue() < 17) {
				Console.WriteLine("Dealar hit.");
				hand.add(deck.popCard());
				System.Console.WriteLine("Dealar's Hand is : " + hand);
				Console.WriteLine("Dealar's Value is : " + hand.getValue());
			}
		}

		public Hand getHand() {
			return hand;
		}
	}
}

