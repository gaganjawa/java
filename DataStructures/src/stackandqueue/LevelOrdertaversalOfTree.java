package stackandqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.binarytrees.tree.BinaryTree;
import com.binarytrees.tree.Node;

import application.BinaryTreeMain;

public class LevelOrdertaversalOfTree {
	
	public static void main(String[] args) {
		
		BinaryTreeMain binaryTreeMain = new BinaryTreeMain();
		BinaryTree bt = new BinaryTree();
		bt = binaryTreeMain.createBinaryTree();
		
		LevelOrdertaversalOfTree levelOrdertaversalOfTree = new LevelOrdertaversalOfTree();
		System.out.println(levelOrdertaversalOfTree.levelOrder(bt));
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
	
	public List<Integer> levelOrder(BinaryTree tree) {
        Queue<Node> queue = new ArrayDeque<Node>();
        Queue<Node> nextQueue = new ArrayDeque<Node>();
        List<Integer> levels = new ArrayList<Integer>();
        List<List<Integer>> levelOrder = new ArrayList<List<Integer>>(); 
        
        queue.add(tree.root);
        
        while(!queue.isEmpty()) {
        	Node node = queue.poll();
        	levels.add(node.value);
        	if (node.left!=null) {
        		queue.add(node.left);
			}
        	if (node.right!=null) {
        		queue.add(node.right);
			}
        }
        
		return levels;
    }

}
