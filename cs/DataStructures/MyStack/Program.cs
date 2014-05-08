using System;

namespace bloodysnow.DataStructures
{
	class StackMainClass
	{
		public static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
		}
	}

	class MyStack<T> {
		MyVector<T> vector = new MyVector<T>();

		bool empty() {
			return vector.size == 0;
		}

		T peek() {
			return vector.get(vector.size - 1);
		}

		T pop() {
			T value = peek();
			vector.remove(vector.size - 1);
			return value;
		}

		T push(T item) {
			vector.add(item);
			return item;
		}
	}
}
