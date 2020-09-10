package com.java.array;

public class RotateMatrixBy90 {
	
//		0   1   2   3
	
//	0	01  02  03 04		13  09  05  01			04	08  12  16
//	1	05  06  07 08	 	14  10  06  02			03  07  11  15
//	2	09  10  11 12		15  11  07  03			02  06  10  14
//	3	13  14  15 16		16  12  08  04			01  05  09  13
	
//	0	01  05  09  13      //Step2
//	1	02  06  10  14  	01<->13=> 0,0 <-> 0,3 (i,j)<->(i,N-j-1)
//	2	03  07  11  15  	05<->09=> 0,1 <-> 0,2 (i,j)<->(i, N-j-1)
//	3	04  08  12  16 		02<->14=> 1,0 <-> 1,3 (i,j)<->(i, N-j-1)
	
//	Step1
//	02<->05 (0,1)<->(1,0)
//	09<->03 (0,2)<->(2,0)
	
//	Counter clockwise
//		Step 1							final matrix
	
//		16	12	08	04				04	08  12  16		
//		15	11	07	03				03  07  11  15
//		14	10	06	02				02  06  10  14
//		13	09	05	01				01  05  09  13
	
//	01<->16 (0,0)<->(3,3)  => (n-j-1),(n-i-1)
//	02<->12 (0,1)<->(2,3)  => (n-j-1),(n-i-1)
//	03<->08 (0,2)<->(1,3)
//	05<->15 (1,0)<->(3,2)  => (n-j-1),(n-i-1)
//	09<->14 (2,0)<->(3,1)  => (n-j-1), (n-i-1)

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 },
						{ 5, 6, 7, 8 },
						{ 9, 10, 11, 12 },
						{ 13, 14, 15, 16 } };
		printMatrix(arr);
		rotate90Clockwise(arr);
		printMatrix(arr);
//		rotate90AntiClockwise(arr);
//		printMatrix(arr);
	}

	private static void rotate90AntiClockwise(int[][] arr) {
		int N = arr.length;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N-j-1][N-i-1];
				arr[N-j-1][N-i-1] = temp;
			}
		}
		swapHorizontal(arr, N);
	}

	private static void swapHorizontal(int[][] arr, int N) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][N-j-1];
				arr[i][N-1-j] = temp;
			}
		}
	}

	private static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("==================================================");
	}

	private static void rotate90Clockwise(int[][] arr) {
		int N = arr.length;

		for (int i = 0; i<N; i++) {
			for (int j = i; j < N; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}		
		
		swapHorizontal(arr, N);
	}

}
