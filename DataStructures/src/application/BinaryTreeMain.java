package application;

import com.binarytrees.tree.BinaryTree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt = createBinaryTree();
		
		System.out.println("DFS traversals");
		bt.traverseInOrder(bt.root);
		System.out.println();
		bt.traversePreOrder(bt.root);
		System.out.println();
		bt.traversePostOrder(bt.root);
		
		System.out.println("\nBFS traversal");
		bt.traverseLevelOrder();
		
	}
	
	//       6
	//     /   \
	//    4     8
	//	 / \   / \
	//	3   5 7   9
	
	private static BinaryTree createBinaryTree() {
	    BinaryTree bt = new BinaryTree();
	    
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	 
	    return bt;
	}

}
