package com.slidingwindow.easy;

public class MinSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
		System.out.println("Smallest subarray length: " + result);// answer = 2
		result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
		System.out.println("Smallest subarray length: " + result);// answer = 1
		result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
		System.out.println("Smallest subarray length: " + result);// answer = 3

	}

	public static int findMinSubArray(int S, int[] arr) {

		int windowSum = 0, minLength = Integer.MAX_VALUE;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd]; // add the next element
			// shrink the window as small as possible until the 'windowSum' is smaller than 'S'
			while (windowSum >= S) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart]; // subtract the element going out
				windowStart++; // slide the window ahead
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

	public static int findMinSubArray1(int S, int[] arr) {

		int k = 1;
		int windowStart = 0;
		int windowSum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			if (windowSum >= S) {
				return k;
			}
			if (windowEnd >= k - 1) {
				windowSum -= arr[windowStart];
				windowStart++;
			}

			if (windowStart > arr.length - 1 || windowStart > arr.length - k) {
				k++;
				windowStart = 0;
				windowEnd = -1;
				windowSum = 0;
			}
		}

		return 0;
	}
}
