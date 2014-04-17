using System;

namespace ArrangeWidget
{
	class Space {
		private int[] widthList;

		public Space(String[] fields, int x, int y) {
			widthList = new int[fields.Length - y];
			widthList[0] = -1;
			for(int i = x; i < fields[y].Length; ++i) {
				if(fields[y][i] == '0') ++widthList[0];
				else break;
			}
			for(int j = 1; j < widthList.Length; ++j) {
				widthList[j] = -1;
				for(int i = x; i <= x + widthList[j - 1]; ++i) {
					if(fields[y + j][i] == '0') ++widthList[j];
					else break;
				}
			}
			/*
				System.Console.Write("Space(" + x.ToString() + ", " + y.ToString() + ") = ");
				foreach(var width in widthList)
					System.Console.Write(width.ToString() + ", ");
				System.Console.WriteLine();
				*/
		}

		public bool canArrange(Widget widget) {
			return widget.S < widthList.Length && widthList[widget.S] >= widget.T;
		}
	}
}

