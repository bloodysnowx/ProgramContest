/* 1. 半径の小さい順に領域を作成する
 * 2. 1つ外の領域と親子関係を生成する
 * 3. treeを辿って移動回数を算出する */

using System;
using System.Collections.Generic;
using System.Linq;

namespace CirclesCountry
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			var countryTree = new CountryTree(new int[]{0}, new int[]{0}, new int[]{2});
			System.Console.WriteLine (countryTree.calc (-5, 1, 5, 1));
			countryTree = new CountryTree(new int[]{0, -6, 6}, new int[]{0, 1, 2}, new int[]{2, 2, 2});
			System.Console.WriteLine (countryTree.calc (-5, 1, 5, 1));
			countryTree = new CountryTree(new int[]{1,-3,2,5,-4,12,12}, new int[]{1,-1,2,5,5,1,1}, new int[]{8,1,2,1,1,1,2});
			System.Console.WriteLine (countryTree.calc (-5, 1, 12, 1));
			countryTree = new CountryTree(new int[]{-3,2,2,0,-4,12,12,12}, new int[]{-1,2,3,1,5,1,1,1}, new int[]{1,3,1,7,1,1,2,3});
			System.Console.WriteLine (countryTree.calc (2, 3, 13, 2));
			countryTree = new CountryTree(new int[]{-107,-38,140,148,-198,172,-179,148,176,153,-56,-187}, new int[]{175,-115,23,-2,-49,-151,-52,42,0,68,109,-174}, new int[]{135,42,70,39,89,39,43,150,10,120,16,8});
			System.Console.WriteLine (countryTree.calc (102, 16, 19, -108));

			Console.WriteLine ("Hello World!");
		}
	}

	class CountryTree {
		class Circle {
			public Circle(int x, int y, int r) { X = x; Y = y; R = r; }
			public int X { get; private set; }
			public int Y { get; private set; }
			public int R { get; private set; }
		}

		private void setRelation(CountryNode outerCountry, CountryNode innerCountry) {
			outerCountry.innerCountries.Add (innerCountry);
			innerCountry.outerCountry = outerCountry;
		}

		CountryNode root;

		public CountryTree(int[] x, int[] y, int[] r) {
			var circles = new List<Circle>();
			for(int i = 0; i < x.Length; ++i) circles.Add(new Circle(x[i], y[i], r[i]));
			circles.Sort ((a, b) => a.R - b.R);

			var allCountries = new List<CountryNode> ();
			foreach (var circle in circles) allCountries.Add (new CountryNode (circle));
			foreach (var newCountry in allCountries)
				foreach (var country in allCountries.Where(country => country.outerCountry == null).Where (country => newCountry.isInner (country))) setRelation (newCountry, country);
			root = new CountryNode (new Circle (0, 0, int.MaxValue));
			foreach (var country in allCountries.Where(country => country.outerCountry == null)) setRelation (root, country);
		}

		public int calc(int x_1, int y_1, int x_2, int y_2) {
			CountryNode startCountry = root.findCountry (x_1, y_1);
			CountryNode endCountry = root.findCountry (x_2, y_2);
			int steps = 0;
			CountryNode currentCountry = startCountry;
			while (currentCountry != endCountry) {
				if (currentCountry.isInner (endCountry)) { foreach (var country in currentCountry.innerCountries) if (country.isInner (endCountry) || country == endCountry) currentCountry = country; }
				else currentCountry = currentCountry.outerCountry;
				steps++;
			}
			return steps;
		}

		class CountryNode {
			public Circle Circle { get; private set; }
			public IList<CountryNode> innerCountries = new List<CountryNode> ();
			public CountryNode outerCountry { get; set; }
			public CountryNode(Circle circle) { Circle = circle; }
			public int X { get { return Circle.X; } }
			public int Y { get { return Circle.Y; } }
			public int R { get { return Circle.R; } }
			public bool isInner(CountryNode node) { return node.R < R && (node.X - X) * (node.X - X) + (node.Y - Y) * (node.Y - Y) < (Int64)R * (Int64)R; }
			bool isInnerPoint(int x, int y) { return (X - x) * (X - x) + (Y - y) * (Y - y) < (Int64)R * (Int64)R; }

			public CountryNode findCountry(int x, int y) {
				if (!isInnerPoint (x, y)) return null;
				foreach (var country in innerCountries)	if (country.isInnerPoint (x, y)) return country.findCountry(x, y);
				return this;
			}
		}
	}
}
