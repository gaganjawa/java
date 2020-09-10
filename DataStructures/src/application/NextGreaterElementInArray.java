package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import stackandqueue.Stack;

public class NextGreaterElementInArray {
	
	public static void main(String[] args) {
		char a = 'a'^'d'^'b';
		char b = 'c'^'e'^'a';
		System.out.println('a'^'d'^'b');
		System.out.println('c'^'e'^'a');
		System.out.println(a^b);
		System.out.println();
		int arr[] = {4,6,3,2,8,1,11}; 
		System.out.println(Arrays.toString(arr));
		int result[] = nextGreaterElement(arr); 
		System.out.println(Arrays.toString(result));
		
		
	}
	
	public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        
        Stack<Integer> stack = new Stack<Integer>(arr.length);

        for(int i = arr.length -1; i>=0; i--) {
        	
        	if (!stack.isEmpty()) {
        		while(!stack.isEmpty() && stack.top() < arr[i]) {
        			stack.pop();
        		}
			}
        	
        	if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.top();
			}
        	stack.push(arr[i]);
        	
        }
        return result;
    }

}
