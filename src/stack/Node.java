package stack;

public class Node<T> {
	
	public Node(T data) {
		this.data = data;
	}
	
	//This constructor is the key, the first element will hold next as null and is TOP
	//The second element will hold top(previous element) and then top will be new element.
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	private T data;
	private Node<T> next;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

}
