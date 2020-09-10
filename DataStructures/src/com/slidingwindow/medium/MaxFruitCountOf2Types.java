package com.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Maximum number of fruits: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		System.out.println("Maximum number of fruits: "
				+ MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
	}

	public static int findLength(char[] arr) {
		
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		int windowStart=0;
		int maxFruit=Integer.MIN_VALUE;
		
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			char rightFruit = arr[windowEnd];
			charFrequencyMap.put(rightFruit, charFrequencyMap.getOrDefault(rightFruit, 0) + 1);
			while (charFrequencyMap.size() > 2) {
				char leftFruit = arr[windowStart];
				charFrequencyMap.remove(leftFruit);
				windowStart++;
			}
			maxFruit = Math.max(maxFruit, windowEnd - windowStart + 1);
		}
		return maxFruit;
	}

}
