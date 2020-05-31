package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayPractice {
	
	public static void main(String[] args) {

		ArrayPractice sumOfTwoIntegersInArray = new ArrayPractice();
		int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
		int [] result = sumOfTwoIntegersInArray.findSum(arr, 27);
		
		System.out.println("Result = ["+result[0]+", "+result[1]+"]");
		
	}

	private int sum;
	
	//sumOfTwoIntegersInArray = n
	public int[] findSum(int[] arr, int n) {
		
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length-1);
		int p1 = 0;
		int p2 = arr.length-1;
		// [1, 3, 5, 6, 7, 14, 21, 60]
		int result[] = new int[2];
		while(p1 != p2) {
			sum = arr[p1] + arr[p2];
			if (sum < n) {
				p1++;
			} else if (sum > n) {
				p2--;
			} else {
				result[0] = arr[p1];
				result[1] = arr[p2];
				return result;
			}
		}
		return arr;
		
	}
	
	//Re-arrange +ve and -ve values
	public void rearrange(int[] arr) {
		int j=0;
		for(int i=0; i<arr.length ; i++) {
			if (arr[i] < 0) {
				if (i!=j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

}
