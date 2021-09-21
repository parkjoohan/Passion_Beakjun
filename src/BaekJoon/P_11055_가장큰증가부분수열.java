package BaekJoon;

import java.util.*;

public class P_11055_가장큰증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max=0;
		for (int i = 0; i < N; i++) {
			LIS[i]=arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && LIS[i]<arr[i]+LIS[j]) {
					LIS[i]=LIS[j]+arr[i];
				}
			}
			if(max<LIS[i]) max=LIS[i];

		}
		System.out.println(max);
	}
}