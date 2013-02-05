import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTree<T extends Comparable<? super T>> {
	public class Node implements Comparable {
		Node left;
		Node right;
		Node parent;
		T value;
		int cost;
		StringBuffer code = new StringBuffer();
		
		private void addCode(char c, Map<T, String> dict) {
			if(left != null) left.addCode(c, dict);
			if(right != null) right.addCode(c, dict);
			if(value != null) { 
				code.insert(0, c);
				dict.put(value, this.code.toString());
			}
		}
		
		public Node(Node left, Node right, T value, int cost) {
			this.left = left;
			if(left != null) { 
				left.parent = this;
				left.addCode('0', dict);
			}
			this.right = right;
			if(right != null) { 
				right.parent = this;
				right.addCode('1', dict);
			}
			this.value = value;
			this.cost = cost;
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}

		@Override
		public int compareTo(Object o) {
			return this.cost - ((Node)o).cost;
		}
	}
	
	private Node nodes;
	public void setNode(Node node) {
		this.nodes = node;
	}
	
	private Map<T, String> dict = new HashMap<T, String>();
	
	public String getCode(Character c)
	{
		return this.dict.get(c);
	}
	
	public String getDictString()
	{
		StringBuffer result = new StringBuffer();
		List<T> sortedList = new ArrayList<T>();
		for(T key : dict.keySet())
			sortedList.add(key);
		Collections.sort(sortedList);
		for(T key : sortedList) {
			if(result.length() > 0) result.append(',');
			result.append(key.toString() + "=" + dict.get(key));
		}
		return result.toString();
	}
}
