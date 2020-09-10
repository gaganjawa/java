package com.java.array;

public class FindSecondMaxInArray {
	
	static int max = Integer.MIN_VALUE;
	static int secMax = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] arr = { -2, -33, -10, -456 };

		System.out.println("Array: " + arrayToString(arr));

		int secMax = findSecondMaximum(arr);

		System.out.println("Second maximum: " + secMax);
	}

	private static int findSecondMaximum(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>max) {
				secMax = max;
				max = arr[i];
			} else if (arr[i] > secMax && arr[i] != max) {
				secMax = arr[i];
			}
		}
		return secMax;
	}

	public static String arrayToString(int arr[]) {
		if (arr.length > 0) {
			String result = "";
			for (int i = 0; i < arr.length; i++) {
				result += arr[i] + " ";
			}
			return result;
		} else {
			return "Empty Array!";
		}
	}

}
