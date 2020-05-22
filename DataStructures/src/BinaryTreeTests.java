import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.binarytrees.tree.BinaryTree;

class BinaryTreeTests {

	@Test
	void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
		BinaryTree bt = createBinaryTree();
		
		assertTrue(bt.containsNode(6));
		assertTrue(bt.containsNode(4));
		
		assertFalse(bt.containsNode(0));
		assertFalse(bt.containsNode(1));
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
