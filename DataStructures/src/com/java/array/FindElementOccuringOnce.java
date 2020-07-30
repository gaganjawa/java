package com.java.array;

public class FindElementOccuringOnce {

	
	public static void main(String[] args) {
		int nums[] = {1, 2, 1, 3, 4, 3, 2};
		
		System.out.println(findElementOccuringOnlyOnce(nums));
	}

	private static int findElementOccuringOnlyOnce(int[] nums) {
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
}
