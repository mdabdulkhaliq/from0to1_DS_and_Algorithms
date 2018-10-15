package binarytrees;

import queue.CircularQueue;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class BreadthFirst {

	public static void breadthFirstTraversal(Node<?> root) throws QueueOverflowException, QueueUnderflowException {
	
		if(root == null)
			return;
		
		CircularQueue<Node> queue = new CircularQueue<>(Node.class); 	
		queue.enQueue(root);
		
		while(!queue.isEmpty()) {
			Node<?> node = queue.deQueue();
			System.out.println(node.getData());
			
			if(node.getLeftChild() != null)
				queue.enQueue(node.getLeftChild());
			
			if(node.getRightChild() != null)
				queue.enQueue(node.getRightChild());
			
		}
	
	
	}
	
}
