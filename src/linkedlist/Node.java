/*Comparable
	A comparable object is capable of comparing itself with another object. 
	The class itself must implements the java.lang.Comparable interface in order to be able to compare 
	its instances.
Comparator
	A comparator object is capable of comparing two different objects. 
	The class is not comparing its instances, but some other class’s instances. 
	This comparator class must implement the java.util.Comparator interface.
*/

package linkedlist;

//T so that data can be of any data type, and Comparable so that we can compare to other nodes
public class Node<T extends Comparable<T>> {
	
	//Constructor to initialize the node.
	public Node(T data){
		this.data = data;
		this.setNext(null);
	}
	
	//Generic data
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	//Generic Node
	private Node<T> next;
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	//String value of the Node is the data.
	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
