package com.binarytrees.tree;

import application.BinaryTreeMain;

public class CreateMirrorTree {
	
	
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
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree = new BinaryTreeMain().createBinaryTree();
		
		tree.root = mirror(tree.root);
		
		tree.traverseLevelOrder();
	}

	private static Node mirror(Node root) {
		
		if (root != null) {
			
			if (root.left != null) {
				mirror(root.left);
			} 
			if (root.right != null) {
				mirror(root.right);
			}
			
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
	
	

}
