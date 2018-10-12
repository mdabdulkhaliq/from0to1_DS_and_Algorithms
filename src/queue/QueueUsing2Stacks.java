package queue;

import stack.Stack;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class QueueUsing2Stacks<T> {

	Stack<T> forwardStack;
	Stack<T> reverseStack;
	
	public QueueUsing2Stacks() {
		forwardStack = new Stack<T>();
		reverseStack = new Stack<T>();
	}
	
	public boolean isFull() {
		return forwardStack.isFull() || reverseStack.isFull();
	}
	
	public boolean isEmpty() {
		return forwardStack.isEmpty() || reverseStack.isEmpty();
	}
	
	public void enQueue(T data) throws QueueOverflowException, StackOverflowException, StackUnderflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		while(!reverseStack.isEmpty()) {
			forwardStack.push(reverseStack.pop());
		}
		forwardStack.push(data);
		
	}
	
	public T deQueue() throws QueueUnderflowException, StackOverflowException, StackUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		while(!forwardStack.isEmpty()) {
			reverseStack.push(forwardStack.pop());
		}
		return reverseStack.pop();
	}
	
}
