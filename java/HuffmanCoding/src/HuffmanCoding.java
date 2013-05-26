import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HuffmanCoding implements Coding {

	@Override
	public byte[] compress(byte[] src) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] deCompress(byte[] src) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class CharCount implements Comparable {
		public char c;
		public int count;
		
		public CharCount(char c, int count) {
			this.c = c;
			this.count = count;
		}

		@Override
		public int compareTo(Object o) {
			CharCount tmp = (CharCount)o;
			return this.count - tmp.count;
		}
	}
	
	private BinaryTree<Character> makeTree(List<CharCount> charCounts) {
		BinaryTree<Character> tree = new BinaryTree<Character>();
		List<BinaryTree.Node> nodes = new ArrayList<BinaryTree.Node>();
		for(CharCount count : charCounts)
			nodes.add(tree.new Node(null, null, count.c, count.count));
		while(nodes.size() > 1)
		{
			Collections.sort(nodes);
			BinaryTree.Node left = nodes.remove(0);
			BinaryTree.Node right = nodes.remove(0);
			nodes.add(tree.new Node(left, right, null, left.cost + right.cost));
		}
		tree.setNode(nodes.get(0));

		return tree;
	}

	@Override
	public String compress(String src) {
		// 1. 出現している文字を列挙する
		// 2. 出現回数をカウントする
		Map<Character, Integer> dict = new Hashtable<Character, Integer>();
		for(char str : src.toCharArray())
		{
			int count = 0;
			if(dict.containsKey(str)) count = dict.get(str);
			dict.put(str, ++count);
		}
		// 3. 出現回数の少ないものから結合して二分木を生成する
		List<CharCount> charCounts = new ArrayList<CharCount>();
		for(Character c : dict.keySet())
		{
			charCounts.add(new CharCount(c, dict.get(c)));
		}
		Collections.sort(charCounts);
		// 4. 二分木に沿って、文字を符号化する
		BinaryTree<Character> tree = this.makeTree(charCounts);
		// 5. 先頭のdictを生成する
		StringBuffer result = new StringBuffer(tree.getDictString());
		result.append(';');
		// 6. 与えられた文字列を符号化していく
		for(char c : src.toCharArray())
			result.append(tree.getCode(c));
		
		return result.toString();
	}

	@Override
	public String deCompress(String src) {
		String[] tmp = src.split(";");
		String[] dictTmp = tmp[0].split(",");
		String code = tmp[1];
		Dictionary<String, String> dict = new Hashtable<String, String>();
		for(String str : dictTmp)
		{
			tmp = str.split("=");
			dict.put(tmp[1], tmp[0]);
		}
		StringBuilder result = new StringBuilder();
		StringBuilder buffer = new StringBuilder();
		
		for(int i = 0; i < code.length(); ++i)
		{
			buffer.append(code.charAt(i));
			String str = dict.get(buffer.toString());
			if(str != null)
			{
				result.append(str);
				buffer = new StringBuilder();
			}
		}
		
		return result.toString();
	}

}
