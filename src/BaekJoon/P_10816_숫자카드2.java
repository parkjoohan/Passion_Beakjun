package BaekJoon;

import java.util.*;

public class P_10816_숫자카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			sb.append(upper(arr, num) - lower(arr,num)).append(" ");
		}
		System.out.println(sb);
	}

	public static int lower(int[] arr, int num) {
		int low = 0;
		int high = arr.length;
		
		while(low<high) {
			int mid = (low+high) / 2;
			if(num<=arr[mid])
				high=mid;
			else
				low=mid+1;
		}
		return low;
	}
	
	public static int upper(int[] arr, int num) {
		int low = 0;
		int high = arr.length;
		
		while(low<high) {
			int mid = (low+high) / 2;
			if(num<arr[mid])
				high=mid;
			else
				low=mid+1;
		}
		return low;
	}
}
