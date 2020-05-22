package com.binarytrees.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public Node root;
	
	static class Node {
		int value;
		Node left, right;
		
		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	
	private Node addRecursive(Node current, int value) {
		
		if (current == null) {
			return new Node(value);
		}
		
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			//value already exists
			return current;
		}
		return current;
	}
	
	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	private boolean containsRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		
		if (value == current.value) {
			return true;
		}
		
		return value < current.value 
				? containsRecursive(current.left, value) 
				: containsRecursive(current.right, value);
	}
	
	public boolean containsNode(int value) {
		return containsRecursive(root, value);
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}
		
		if (value == current.value) {
			// Node found
			
			//Case 1: the node has no child nodes - set parent = null
			if (current.left == null && current.right == null) {
				return null;
			} 
			
			//Case 2: the node one child - replace parent with the child node
			if (current.left == null) {
				return current.right;
			}
			
			if (current.right == null) {
				return current.left;
			}
			
			//Case 3: the node has 2 child nodes - need to reorganize tree
			//Replace current node with its right subtree's smallest value
			//then delete value from the subtree
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
		}
		
		current.right = deleteRecursive(current.right, value);
		
		return current;
	}
	
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	//DFS method
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}
	
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}
	
	//BFS method
	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}
		
		Queue<BinaryTree.Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			
			Node node = nodes.remove();
			
			System.out.print(" " + node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
	
	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
	
}
