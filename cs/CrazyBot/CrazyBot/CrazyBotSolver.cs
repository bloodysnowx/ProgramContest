using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;

/* 1. stackからデータを取得する
 * 2. 同じ点を通ったかどうかチェックする。通っていれば通ったパターンとして破棄し、1に戻る
 * 3. 指定された歩数歩いたかどうかチェックする。歩いていれば無事に歩けたパターンとして記録し、1に戻る
 * 4. 4方向に歩き、歩いたデータをstackに積み、1に戻る
 * 5. stackが空になれば、無事に歩けたパターンの確立を合算して終了する */

namespace CrazyBot
{
	public class CrazyBotSolver : ICrazyBotSolver
	{
		public Decimal solve(int n, int east, int west, int south, int north) {
			var walkingStack = new Stack<WalkingData>();
			var successList = new List<WalkingData>();
			walkingStack.Push(new WalkingData());

			while (walkingStack.Count > 0) {
				var currentWalkingData = walkingStack.Pop();
				if(currentWalkingData.Probability <= 0m) continue;
				if(currentWalkingData.isVisitedTheSamePoint()) continue;
				if(currentWalkingData.getSteps() == n) { successList.Add (currentWalkingData); continue; }
				walkingStack.Push((new WalkingData(currentWalkingData)).walkEast(east));
				walkingStack.Push((new WalkingData(currentWalkingData)).walkWest(west));
				walkingStack.Push((new WalkingData(currentWalkingData)).walkSouth(south));
				walkingStack.Push((new WalkingData(currentWalkingData)).walkNorth(north));
			}

			return (from successWalkingData in successList select successWalkingData.Probability).Sum();
		}

		private class WalkingData {
			private int x = 0;
			private int y = 0;
			public Decimal Probability { get; private set; }
			private IList<Point> footPrints = new List<Point>();

			public WalkingData(){ Probability = 1m;	}
			public WalkingData(WalkingData origin) {
				x = origin.x;
				y = origin.y;
				Probability = origin.Probability;
				footPrints = new List<Point>(origin.footPrints);
			}

			public WalkingData walkEast(int probability) { footPrints.Add(new Point(x, y)); ++x; this.Probability *= probability / 100m; return this; }
			public WalkingData walkWest(int probability) { footPrints.Add(new Point(x, y)); --x; this.Probability *= probability / 100m; return this; }
			public WalkingData walkSouth(int probability) { footPrints.Add(new Point(x, y)); --y; this.Probability *= probability / 100m; return this; }
			public WalkingData walkNorth(int probability) { footPrints.Add(new Point(x, y)); ++y; this.Probability *= probability / 100m; return this; }
			public bool isVisitedTheSamePoint() { return footPrints.Any (p => p.X == x && p.Y == y); }
			public int getSteps() { return footPrints.Count; }
		}
	}
}

