import java.nio.ByteBuffer;
import java.util.*;

public class HuffmanCoding implements Coding {

	@Override
	public byte[] compress(byte[] src) {
        String sourceString = new String(src);
        List<CharCount> charCounts = createSortedCharCountList(sourceString);
		BinaryTree<Character> tree = this.makeTree(charCounts);

        StringBuffer codeString = new StringBuffer();
		for(char c : sourceString.toCharArray())
			codeString.append(tree.getCode(c));

        byte[] dict = (tree.getDictString() + ";").getBytes();
        byte[] code = codeStringToBits(codeString.toString());
        byte[] result = new byte[dict.length + code.length];
        System.arraycopy(dict, 0, result, 0, dict.length);
        System.arraycopy(code, 0, result, dict.length, code.length);

        return result;
	}

    private byte[] codeStringToBits(String src) {
        BitSet bitset = new BitSet(src.length());
        for(int i = 0; i < src.length(); ++i) {
            if(src.charAt(i) == '1') bitset.set(i);
            else bitset.clear(i);
        }
        return bitset.toByteArray();
    }

	@Override
	public byte[] deCompress(byte[] src) {
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

    private Map<Character, Integer> createCharacterCountMap(String src) {
        Map<Character, Integer> dict = new Hashtable<Character, Integer>();
		for(char str : src.toCharArray())
		{
			int count = 0;
			if(dict.containsKey(str)) count = dict.get(str);
			dict.put(str, ++count);
		}
        return dict;
    }

    private List<CharCount> createSortedCharCountList(String src) {
        Map<Character, Integer> dict = createCharacterCountMap(src);
		List<CharCount> charCounts = new ArrayList<CharCount>();
		for(Character c : dict.keySet())
		{
			charCounts.add(new CharCount(c, dict.get(c)));
		}
		Collections.sort(charCounts);
        return charCounts;
    }

	@Override
	public String compress(String src) {
		// 1. 出現している文字を列挙する
		// 2. 出現回数をカウントする
        List<CharCount> charCounts = createSortedCharCountList(src);
		// 3. 出現回数の少ないものから結合して二分木を生成する
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

    private Dictionary<String, String> readCodeDict(String src) {
        Dictionary<String, String> dict = new Hashtable<String, String>();
        String[] dictTmp = src.split(",");
        for(String str : dictTmp)
        {
            String[] tmp = str.split("=");
            dict.put(tmp[1], tmp[0]);
        }
        return dict;
    }

    private String decode(String code, Dictionary<String, String> dict) {
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

	@Override
	public String deCompress(String src) {
        int separator = src.indexOf(';');
		String code = src.substring(separator + 1);
        Dictionary<String, String> dict = readCodeDict(src.substring(0, separator));
        return decode(code, dict);
	}
}
