using System;
using System.Collections.Generic;

namespace MyVector
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			var vector = new MyVector<int>();
			vector.add(3);
			vector.add(5);
			vector.add(10);
			foreach(int i in vector)
				System.Console.WriteLine(i);
		}
	}

	class MyVector<T> : IEnumerable<T> {
		private T[] buffer;
		private int _size;

		public MyVector() : this(0) { }

		public MyVector(int size) {
			_size = size;
			buffer = new T[size];
		}

		public bool add(T t) {
			if(buffer.Length >= _size) expandBuffer();
			buffer[_size++] = t;
			return true;
		}

		private void expandBuffer() {
			T[] tmpBuffer = new T[Math.Max(buffer.Length, 1) * 2];
			for(int i = 0; i < buffer.Length; ++i)
				tmpBuffer[i] = buffer[i];
			buffer = tmpBuffer;
		}

		public bool contains(T t) {
			for(int i = 0; i < _size; ++i)
				if(t.Equals(buffer[i]))
					return true;

			return false;
		}

		public T get(int index) { return buffer[index]; }

		public T set(int index, T t) { 
			T tmp = buffer[index];
			buffer[index] = t;
			return tmp;
		}

		public int size() { return _size; }

		public T remove(int index) {
			T[] tmpBuffer = new T[buffer.Length];
			for(int i = 0; i < index; ++i)
				tmpBuffer[i] = buffer[i];
			T tmp = buffer[index];
			for(int i = index + 1; i < _size; ++i)
				tmpBuffer[i - 1] = buffer[i];

			buffer = tmpBuffer;
			_size--;
			return tmp;
		}

		public void add(int index, T t) {
			T[] tmpBuffer = new T[buffer.Length >= _size ? buffer.Length * 2 : buffer.Length];
			for(int i = 0; i < index; ++i)
				tmpBuffer[i] = buffer[i];
			tmpBuffer[index] = t;
			_size++;
			for(int i = index + 1; i < _size; ++i)
				tmpBuffer[i] = buffer[i - 1];

			buffer = tmpBuffer;
		}

		#region IEnumerable implementation
		public IEnumerator<T> GetEnumerator()
		{
			for(int i = 0; i < _size; ++i)
				yield return buffer[i];
		}

		System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
		{
			return GetEnumerator();
		}
		#endregion
	}
}
