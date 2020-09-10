package com.java.series;

public class SumOfKTerms {

	public static void main(String[] args) {

		sumOfPrevK(8, 3);
	}

	private static void sumOfPrevK(int N, int k) {

		int prevSum = 0;
		int[] arr = new int[N];
		arr[0]=1;
		
		for (int i = 0; i < N-1; i++) {
			
			if (i<k) {
				arr[i+1] = prevSum + arr[i];
				prevSum = arr[i+1];
			} else {
				arr[i+1] = arr[i] + prevSum - arr[i+1-k];
				prevSum = arr[i] + prevSum;
			}
			
		}
		
		for (int i = 0; i < N; i++) { 
            System.out.print(arr[i] + " "); 
        } 
	}
}
