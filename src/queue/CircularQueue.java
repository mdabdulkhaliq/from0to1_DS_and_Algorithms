package queue;

import java.lang.reflect.Array;

//For going in circular manner in an array and to get circular index's use the operation
// (index + 1) % sizeOfArray

public class CircularQueue<T> {

	private int MAX_SIZE = 40;
	private int headIndex = -1;
	private int tailIndex = -1;
	private T[] elements;

	public CircularQueue(Class<T> claszz) {
		//Creating an array using Generics.
		elements = (T[]) Array.newInstance(claszz, MAX_SIZE);
	}

	public boolean isEmpty() {
		return headIndex == -1;
	}

	public boolean isFull() {
		int nextIndex =  (tailIndex + 1) % elements.length;
		return nextIndex == headIndex;
	}

	public void enQueue(T data) throws QueueOverflowException {
		if(isFull())
			throw new QueueOverflowException();

		tailIndex = (tailIndex + 1) % elements.length;
		elements[tailIndex] = data;

		if (headIndex == -1) {
			headIndex = tailIndex;
		}
	}

	public T deQueue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();

		T deletedElement = elements[headIndex];

		if (headIndex == tailIndex) {
			headIndex = -1;
		}
		else {
			headIndex = (headIndex + 1) % elements.length;
		}
		return deletedElement;
	}

}
