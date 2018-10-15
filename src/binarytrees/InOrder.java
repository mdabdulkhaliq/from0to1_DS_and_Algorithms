package binarytrees;

public class InOrder {

	public static void inOrderTraversal(Node<Integer> root) {
		
		if(root == null)
			return;
		
		inOrderTraversal(root.getLeftChild());
		
		System.out.println(root.getData());
		
		inOrderTraversal(root.getRightChild());
		
	}
	
}
