package week3.Wednesday;

import java.util.Stack;

public class Brackets {

	private static Stack<Character> stack = new Stack<>();

	public static boolean is_balanced(String s) {
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			} else
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(Brackets.is_balanced("(((()()())))((())())"));
	}

}
