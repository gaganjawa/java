package com.java.string;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class FindNextPallindrome {

	public static void main(String[] args) {
		
		String number = "123454322"; 
		
		System.out.println("Number: " + number);
		
		String pallindrome = nextPalindrome(number);
		
		System.out.println("Next Pallindrome:" + pallindrome);
	}
	
	private static String nextPalindrome(String num) {
		
		int len = num.length();
		String left = num.substring(0, len/2);
		String mid = num.substring(len/2, len-len/2);
		String right = num.substring(len - len/2);
		
		if (right.compareTo(reverse(left))<0) {
			return left + mid + reverse(left);
		}
		
		String next = new BigInteger(left+mid).add(BigInteger.ONE).toString();
		return next.substring(0, left.length() + mid.length()) 
				+ reverse(next).substring(mid.length());
	}
	
    private static String reverse(String left) {
		return new StringBuilder(left).reverse().toString();
	}

	@Test
    public void testNextPalindrome() {
        assertEquals("5", nextPalindrome("4"));
        assertEquals("11", nextPalindrome("9"));
        assertEquals("22", nextPalindrome("15"));
        assertEquals("101", nextPalindrome("99"));
        assertEquals("151", nextPalindrome("149"));
        assertEquals("123454321", nextPalindrome("123450000"));
        assertEquals("123464321", nextPalindrome("123454322"));
    }

}
