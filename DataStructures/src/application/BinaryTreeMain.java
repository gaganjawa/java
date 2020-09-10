package application;

import com.binarytrees.tree.BinaryTree;

public class BinaryTreeMain {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt = new BinaryTreeMain().createBinaryTree();
		
		System.out.println("DFS traversals :");
		bt.traverseInOrder(bt.root);
		System.out.println();
		bt.traversePreOrder(bt.root);
		System.out.println();
		bt.traversePostOrder(bt.root);
		
		System.out.println("\nBFS traversal:");
		bt.traverseLevelOrder();
		System.out.println();
		
		int v = 1;
		System.out.println("In order predecessor " +v+":");
		bt.findPredecessor(v);
		System.out.println();
		
		System.out.println("In order sucessor " +v+ ":");
		bt.findSucessor(v);
		
	}
	
	//			   11
	//			  /	 \
	//			 /	  \
	//          /	   \
	//		   6	   15
	//    	 /   \    /  \
	//    	4     8  13  20
	//	   / \   / \     /
	// 	  3   5 7   10	17
	//	 /		   /
	//  1		  9
	
	public BinaryTree createBinaryTree() {
	    BinaryTree bt = new BinaryTree();
	    
	    bt.add(11);
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(10);
	    bt.add(9);
	    bt.add(1);
	    bt.add(15);
	    bt.add(20);
	    bt.add(17);
	    bt.add(13);
	 
	    return bt;
	}

}
