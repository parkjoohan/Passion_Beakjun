package BaekJoon;

import java.util.*;

public class P_2846_오르막길 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int max=0;
		int cnt=0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N-1; i++) {
			if(arr[i]<arr[i+1]) 
				cnt += (arr[i+1]-arr[i]);
			else
				cnt=0;
			max=Math.max(max,cnt);
		}
		System.out.println(max);
	}
}