package BaekJoon;

import java.util.*;

public class P_1940_주몽 {

	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
	  
		int cnt = 0;
		
		// start를 차롇대로 증가시키며 반복
		for(int start = 0; start <arr.length-1; start++) {
			for (int end = start+1; end < arr.length; end++) {
				if(arr[start] + arr[end] == M) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
} 