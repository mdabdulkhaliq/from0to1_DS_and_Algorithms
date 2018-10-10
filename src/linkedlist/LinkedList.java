package linkedlist;

//Linked Lists will have the HEAD node..
//LL will be of a generic type and should be comparable
public class LinkedList<T extends Comparable<T>> implements Cloneable {

	private Node<T> head = null;

	public LinkedList(Node<T> head) {
		this.head = head;
	}

	public LinkedList() {
		this.head = null;
	}

	//Counting the no of elements in a Linked List
	public int size() {
		int count = 0;
		Node<T> currentNode = head;
		while(currentNode != null) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}

	//Add a new node to the beginning of the LL
	public void addFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		head = newNode;
	}

	//Adding a new node to the end of the LL
	public void addLast(T data) {
		Node<T> currentNode = head;
		Node<T> newNode =  new Node<T>(data);
		if(head == null) {
			head = newNode;
		} else {
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
	}

	//Add a new node at the specified index
	public void addAtIndex(int index, T data) {
		Node<T> newNode = new Node<T>(data);
		int size = size();
		if (index > size+1 || index < 0) {
			System.out.println("Invalid index");
			return;
		}

		if(index == 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			int position=0;
			Node<T> currentNode = head;
			Node<T> previousNode = head;
			while(currentNode.getNext() != null) {
				previousNode = currentNode;
				currentNode = currentNode.getNext();	
				position = position + 1;
				if(position == index) {
					previousNode.setNext(newNode);
					newNode.setNext(currentNode);
					return;
				}
			}
			currentNode.setNext(newNode);
		}

	}

	//Remove an element from the LL.
	public void deleteAll(T data){
		if(head != null) {
			while(head.getData() == data) {
				head = head.getNext();
			}
			Node<T> currentNode = head;
			Node<T> previousNode = head;
			while(currentNode != null) {
				if(currentNode.getData() == data) {
					previousNode.setNext(currentNode.getNext());
					currentNode = currentNode.getNext();
				}else {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		}
	}

	//Delete the last node in the LL
	public void deleteLast() {
		Node<T> currentNode = head;
		Node<T> previousNode = head;
		while(currentNode.getNext() != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();			
		}
		previousNode.setNext(null);
	}

	//Remove the first Element from the LL.
	public T deleteFirst(){
		if(head != null) {
			T firstElement = head.getData();
			head = head.getNext();
			return firstElement;
		}
		return null;
	}

	//Get the first node in the LL
	public T getFirst() {
		if (head == null)
			return null;
		else
			return head.getData();
	}

	//Get the last node in the LL
	public T getLast() {
		Node<T> currentNode = head;
		if(head == null) {
			return null;
		}else if(head.getNext() == null) {
			return head.getData();
		}else {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getData();
		}
	}

	public boolean contains(T data) {
		if(head != null) {
			Node<T> currentNode = head;
			while(currentNode != null) {
				if(currentNode.getData() == data) {
					return true;
				}else {
					currentNode = currentNode.getNext();
				}
			}
		}
		return false;
	}

	public int indexOf(T data) {
		if(head != null) {
			Node<T> currentNode = head;
			int index = -1;
			while(currentNode != null) {
				index = index + 1;
				if (currentNode.getData() == data) {
					return index;
				}else {
					currentNode = currentNode.getNext();
				}
			}
		}
		return -1;
	}

	public int lastIndexOf(T data) {
		if(head != null) {
			Node<T> currentNode = head;
			int index = -1;
			int foundAt = -1;
			while(currentNode != null) {
				System.out.println("current node data" + currentNode.getData());
				System.out.println("data" + data);
				index = index + 1;
				if (currentNode.getData() == data) {
					foundAt =  index;					
				}
				currentNode = currentNode.getNext();
			}

			return foundAt;

		}
		return -1;
	}

	public void print() {
		Node<T> currentNode = head;
		System.out.println("***************************************");
		while(currentNode != null) {
			System.out.print(currentNode.getData() + "-");
			currentNode = currentNode.getNext();
		}
		System.out.println("");
		System.out.println("***************************************");
	}

}
