using System;
using System.Collections.Generic;

namespace BlackJack
{
	public class Game
	{
		Dealer dealer;
		Player player;

		public Game()
		{
			dealer = new Dealer();
			dealer.shuffle();
			dealer.init();
			player = new Player(new Hand(new List<Card>(){dealer.hit(), dealer.hit()}), dealer);
			player.start();
			dealer.start();

			bool playerWin = false;
			if(player.getHand().isBursted())
				playerWin = false;
			else if(dealer.getHand().isBursted())
				playerWin = true;
			else if(player.getHand().getValue() > dealer.getHand().getValue())
				playerWin = true;
			else if(player.getHand().isBlackJack() && !dealer.getHand().isBlackJack())
				playerWin = true;
			System.Console.WriteLine(playerWin ? "Win" : "Lose");

			Console.ReadLine();
		}
	}
}

