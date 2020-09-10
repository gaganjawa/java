package com.binarytrees.tree;

import application.BinaryTreeMain;

public class BoundaryTraversalTree {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTreeMain().createBinaryTree();
		tree.add(21);
		boundaryTraversal(tree.root);
		
	}
	
	public static void boundaryTraversal(Node root) {
		System.out.print(root.value + "  ");
		traverseAndPrintLeftBoundary(root.left);
		printLeafNodes(root);
		traverseAndPrintRightBoundary(root.right);
	}

	private static void traverseAndPrintRightBoundary(Node node) {
		if (node == null)
			return;
		if (node.right != null) {
			traverseAndPrintRightBoundary(node.right);
			System.out.print(node.value + "  ");
		} else if (node.left != null) {
			traverseAndPrintRightBoundary(node.left);
			System.out.print(node.value + "  ");
		}
	}

	private static void printLeafNodes(Node root) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.print(root.value + "  ");
			return;
		}
		if (root.left != null) {
			printLeafNodes(root.left);
		}
		if (root.right != null) {
			printLeafNodes(root.right);
		}
	}

	//			   11
	//			  /	 \
	//			 /	  \
	//          /	   \
	//		   6	   15
	//    	 /   \    /  \
	//    	4     8  13  20
	//	   / \   / \     / \
	// 	  3   5 7   10	17  21
	//	 /		   /
	//  1		  9
	private static void traverseAndPrintLeftBoundary(Node node) {

		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print(node.value + "  ");
			traverseAndPrintLeftBoundary(node.left);
		} else if (node.right != null) {
			System.out.print(node.value + "  ");
			traverseAndPrintLeftBoundary(node.right);
		}
	}

}
