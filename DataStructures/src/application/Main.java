package application;

import com.binarytrees.tree.BinaryTree;

public class Main {

	public static void main(String[] args) {
		System.out.println(createBinaryTree());
	}
	
	
	private static void printInorderTraversal(BinaryTree bt) {
		
		while(true) {
			while(bt != null) {
				
			}
		}
	}
	
	
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
