package stack;

public class Stack<T> {

	private static int MAX_SIZE = 40;
	private Node<T> top = null;
	private int currentSize = 0;
	
	public Stack() {
		
	}
	
	public void print() {
		Node<T> currentNode = top;
		while (currentNode != null) {
			System.out.print(currentNode.getData() + "-");
			currentNode = currentNode.getNext();
		}
	}
	
	public void push(T data) throws StackOverflowException {
		if (currentSize == MAX_SIZE) {
			throw new StackOverflowException();
		}
		Node<T> newNode = new Node<T>(data, top);
		top = newNode;
		currentSize++;
	}
	
	public T pop() throws StackUnderflowException {
		if (top == null)
			throw new StackUnderflowException();
		T data = top.getData();
		top = top.getNext();
		currentSize--;
		return data;
	}
	
	public T peek() throws StackUnderflowException {
		if (top == null)
			throw new StackUnderflowException();
		return top.getData();
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public boolean isFull() {
		return currentSize == MAX_SIZE;
	}
	
	public int size() {
		return currentSize;
	}
		
}
