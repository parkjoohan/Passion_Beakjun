package BaekJoon;

import java.util.*;

public class P_2217_로프 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int max = arr[N];
		
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, arr[i]*(N-(i-1)));
		}
		System.out.println(max);
	}
}