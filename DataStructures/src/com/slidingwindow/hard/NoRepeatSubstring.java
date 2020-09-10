package com.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
		System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
	}

	//using charIndexMap
	public static int findLength(String str) {

		Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
		int windowStart = 0;
		int maxLength = Integer.MIN_VALUE;

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			if (charIndexMap.containsKey(rightChar)) {
				windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
			}
			charIndexMap.put(rightChar, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	//using charFreqencyMap
	public static int findLength1(String str) {

		Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();
		int windowStart = 0;
		int maxLength = Integer.MIN_VALUE;

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			if (charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1) != null) {
				char leftChar = str.charAt(windowStart);
				charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
				if (charFrequencyMap.get(leftChar) == 0) {
					charFrequencyMap.remove(leftChar);
				}
				windowStart = windowEnd;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
