package application;

import stackandqueue.Stack;

public class StackMain {
	
    public static void main( String args[] ) {
        Stack<Integer> stack = new Stack<Integer>(10);
				
        //output if stack is empty or not
        if(stack.isEmpty())
        System.out.print("Stack is empty");
        else
        System.out.print("Stack is not empty");
        
        System.out.printf("%n");
        
        //output if stack is full or not
        if(stack.isFull())
        System.out.print("Stack is full");
        else
        System.out.print("Stack is not full");
    }
}