package com.binarytrees.tree;

import org.junit.jupiter.api.Test;

public class BinaryTree {

	Node root;
	
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
		if (current != null) {
			return null;
		}
		
		if (current.value == value) {
			// Node found
			// ..code to delelte the code
		}
		
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
		}
		
		current.right = deleteRecursive(current.right, value);
		
		return current;
	}
	
	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
	
}
