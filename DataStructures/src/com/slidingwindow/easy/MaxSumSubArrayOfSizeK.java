package com.slidingwindow.easy;

public class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {
		System.out.println("Maximum sum of a subarray of size K: "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		System.out.println("Maximum sum of a subarray of size K: "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	}

	public static int findMaxSumSubArray(int k, int[] arr) {
		int windowStart = 0;
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if (windowEnd >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}

		return maxSum;
	}

}
