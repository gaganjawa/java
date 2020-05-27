package util;

public class SumOfTwoIntegersInArray {
	
	public static void main(String[] args) {
		SumOfTwoIntegersInArray sumOfTwoIntegersInArray = new SumOfTwoIntegersInArray();
		int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
		int [] result = sumOfTwoIntegersInArray.findSum(arr, 27);
		
		System.out.println("Result = ["+result[0]+", "+result[1]+"]");
	}

	private int sum;
	
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

}
