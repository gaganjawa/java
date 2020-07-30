package com.binarytrees.tree;

public class Node {
	
	public Integer value;
	public Node left;
	public Node right;
	protected Integer value2;

	public Node() {
	}
	
	public Node(int value) {
		this.value = value;
		this.left = null;
	}

}