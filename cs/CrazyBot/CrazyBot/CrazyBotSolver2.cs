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
	public class CrazyBotSolver2 : ICrazyBotSolver
	{
		Stack<WalkingData> walkingStack = new Stack<WalkingData>();
		IList<Point> visitedPointList = new List<Point>();

		public Decimal solve(int n, int east, int west, int south, int north) {
			var probability = 0m;
			walkingStack = new Stack<WalkingData>();
			visitedPointList = new List<Point>();
			int[] x_array = { 1, -1, 0, 0 };
			int[] y_array = { 0, 0, -1, 1 };
			int[] prob_array = { east, west, south, north };

			walkingStack.Push(new WalkingData(1m, 0, 0, 0));
			while(walkingStack.Count > 0) {
				var currentWalkingData = walkingStack.Pop();
				while(currentWalkingData.Steps != visitedPointList.Count) visitedPointList.RemoveAt(visitedPointList.Count - 1);
				if(isVisitedTheSamePoint(currentWalkingData.X, currentWalkingData.Y)) continue;
				if(currentWalkingData.Steps == n) {	probability += currentWalkingData.Probability; continue; }
				visitedPointList.Add(new Point(currentWalkingData.X, currentWalkingData.Y));
				for(int i = 0; i < 4; ++i) walkingStack.Push(currentWalkingData.walk(x_array[i], y_array[i], prob_array[i]));
			}
			return probability;
		}

		private bool isVisitedTheSamePoint(int x, int y) { return visitedPointList.Any(p => p.X == x && p.Y == y); }

		private class WalkingData {
			public Decimal Probability { get; private set; }
			public int Steps { get; private set; }
			public int X { get; private set; }
			public int Y { get; private set; }

			public WalkingData(Decimal probability, int steps, int x, int y) {
				this.Probability = probability;
				this.Steps = steps;
				this.X = x;
				this.Y = y;
			}
			public WalkingData walk(int x, int y, int probability) { return new WalkingData(this.Probability * probability / 100m, this.Steps + 1, this.X + x, this.Y + y); }
		}
	}
}

