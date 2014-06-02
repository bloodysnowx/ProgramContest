using System;

namespace bloodysnow.DataStructures
{
	class StackMainClass
	{
		public static void Main(string[] args)
		{
			var stack = new MyStack<int>();
			stack.push(3);
			stack.push(5);
			stack.push(10);

			while(!stack.empty())
				System.Console.WriteLine(stack.pop());
		}
	}

	class MyStack<T> {
		MyVector<T> vector = new MyVector<T>();

		public bool empty() { return vector.size() == 0; }

		public T peek() { return vector.get(vector.size() - 1); }

		public T pop() {
			T value = peek();
			vector.remove(vector.size() - 1);
			return value;
		}

		public T push(T item) {
			vector.add(item);
			return item;
		}
	}
}
