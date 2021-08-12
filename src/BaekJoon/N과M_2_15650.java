package BaekJoon;

import java.util.Scanner;

public class N과M_2_15650 {
	static int N, M;
	public static int[] arr;
	public static boolean[] check;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
 
		arr = new int[M];
		check = new boolean[N];
		Result(0);
 
	}
 
	public static void Result(int idx) {
		if (idx == M) {
			for(int i=0; i<M-1; i++) {
				if(arr[i] > arr[i+1])
					return;
			}
			
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[idx] = i + 1;
				Result(idx + 1);
				check[i] = false;
			}
		}
	}
}