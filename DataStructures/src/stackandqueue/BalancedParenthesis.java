package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {

	public static void main(String[] args) {
		String expr = "([{}])"; 
        if (areParanthesisBalanced(expr)) 
            System.out.println("Balanced "); 
        else
            System.out.println("Not Balanced "); 
	}

	private static boolean areParanthesisBalanced(String expr) {
		
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '{' || x == '[') {
				stack.push(x);
			}
			
			if (stack.isEmpty()) {
				return false;
			}
			
			char y = '\u0000';
			switch (x) {
			case ')':
				y= stack.pop();
				if (y == '{' || y == '[') {
					return false;
				}
				break;
			case '}':
				y= stack.pop();
				if (y == '(' || y == '[') {
					return false;
				}
				break;
			case ']':
				y= stack.pop();
				if (y == '{' || y == '(') {
					return false;
				}
				break;

			default:
				break;
			}
		}
		return stack.isEmpty();
	}
}
