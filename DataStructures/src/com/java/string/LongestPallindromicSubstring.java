package com.java.string;

public class LongestPallindromicSubstring {

	public static void main(String[] args) {
		String s = "babad";
		String result = longestPallindrome("forgeeksskeegfor");
		System.out.println(result);
	}

	private static String longestPallindrome(String s) {
		
		if (s.length()<=1) {
			return s;
		}
		String result = s.substring(0,1);
		for (int i = 0; i < s.length(); i++) {
			String temp = expand(s, i, i); //odd length
			result = max(temp, result);
			temp = expand(s, i, i+1); //even length
			result = max(temp, result);
		}
		return result;
	}
	
	private static String max(String temp, String result) {
		return temp.length() > result.length() ? temp : result;
	}

	private static String expand(String s, int left, int right) {
		while (left>=0 && right<s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else break;
		}
		return s.substring(left+1, right);
	}

	public static boolean isPallindrome(String s) {
		return new StringBuilder(s).reverse().equals(s);
	}
}
