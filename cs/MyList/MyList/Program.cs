using System;
using System.Collections.Generic;

namespace bloodysnow.DataStructures
{
	class ListMainClass
	{
		public static void Main(string[] args)
		{
			var list = new MyList<int>();
			list.add(3);
			list.add(5);
			list.add(10);
			foreach(int i in list)
				System.Console.WriteLine(i);
		}
	}

	public class MyList<T> : IEnumerable<T> {

		class Node {
			public T value;
			public Node nextNode = null;
			public Node(T value) { this.value = value; }
		}

		Node startNode = new Node(default(T));

		public bool add(T t) {
			Node newNode = new Node(t);
			getEndNode().nextNode = newNode;
			return true;
		}

		private Node getEndNode() {
			Node currentNode = startNode;
			while(currentNode.nextNode != null)
				currentNode = currentNode.nextNode;

			return currentNode;
		}

		public bool contains(T t) {
			Node currentNode = startNode;

			while(currentNode != null) {
				if(currentNode.value.Equals(t))
					return true;
				else
					currentNode = currentNode.nextNode;
				}
			return false;
		}

		public T get(int index) {
			Node targetNode = getNode(index);
			return targetNode == null ? default(T) : targetNode.value;
		}

		public T set(int index, T t) {
			Node targetNode = getNode(index);
			T value = default(T);
			if(targetNode != null) {
				value = targetNode.value;
				targetNode.value = t;
			}
			return value;
		}

		private Node getNode(int index) {
			int count = 0;
			Node currentNode = startNode.nextNode;

			while(currentNode != null) {
				if(count++ == index)
					return currentNode;
				else
					currentNode = currentNode.nextNode;
			}
			return null;
		}

		public int size() {
			int count = 0;
			Node currentNode = startNode.nextNode;

			while(currentNode != null) {
				count++;
				currentNode = currentNode.nextNode;
			}
			return count;
		}

		public T remove(int index) {
			Node targetNode = startNode;
			if(index > 0)
				targetNode = getNode(index - 1);
			T value = targetNode.value;

			targetNode.nextNode = targetNode.nextNode.nextNode;
			return value;
		}

		public void add(int index, T t) {
			Node targetNode = startNode;
			if(index > 0)
				targetNode = getNode(index - 1);

			Node newNode = new Node(t);
			newNode.nextNode = targetNode.nextNode;
			targetNode.nextNode = newNode;
		}

		#region IEnumerable implementation

		public IEnumerator<T> GetEnumerator()
		{
			Node currentNode = startNode.nextNode;

			while(currentNode != null) {
				T value = currentNode.value;
				currentNode = currentNode.nextNode;
				yield return value;
			}
		}

		#endregion

		#region IEnumerable implementation

		System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}

		#endregion


	}
}
