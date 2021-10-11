package BaekJoon;

import java.util.*;

public class P_1026_보물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			arr2[i] = sc.nextInt();
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int sum=0;
		for (int i = 0; i < N; i++) {
			sum += arr1[i]*arr2[N-i-1];
		}
		System.out.println(sum);
	}
}