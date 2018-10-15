package binarytrees;

public class PreOrder {

	public static void preOrderTraversal(Node<Integer> root) {
		
		if(root == null)
			return;
		
		System.out.println(root.getData());
		
		preOrderTraversal(root.getLeftChild());
		
		preOrderTraversal(root.getRightChild());
		
	}
	
}
