using System;

namespace BlackJack
{
	public class Player
	{
		Hand hand;
		Dealer dealer;

		public Player(Hand hand, Dealer dealer)
		{
			this.hand = hand;
			this.dealer = dealer;
		}

		public void start() {
			string line;
			Console.WriteLine("press CTRL+C to exit");
			do { 
				Console.WriteLine("Your Hand is : " + hand);
				Console.WriteLine("Your Value is : " + hand.getValue());
				Console.WriteLine("Dealar's Face Card is : " + dealer.getFaceCard());
				if(hand.getValue() > 21) { 
					Console.WriteLine("You are bursted.");
					return;
				}

				line = Console.ReadLine();
				if (line != null && line.Length > 0) {
					if(line[0].CompareTo('h') == 0) hand.add(dealer.hit());
					else if(line[0].CompareTo('s') == 0) return;
				}
			} while (line != null);
		}

		public Hand getHand() {
			return hand;
		}
	}
}

