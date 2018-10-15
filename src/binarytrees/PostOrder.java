package binarytrees;

public class PostOrder {

	public static void postOrderTraversal(Node<Integer> root) {
		
		if(root == null)
			return;
		
		postOrderTraversal(root.getLeftChild());
		
		postOrderTraversal(root.getRightChild());
		
		System.out.println(root.getData());
		
	}
	
}
