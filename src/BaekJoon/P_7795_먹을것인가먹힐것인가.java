package BaekJoon;

import java.util.*;

public class P_7795_먹을것인가먹힐것인가 {

	static int T, N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			
			for (int i = 0; i < N; i++) {
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arr2[i] = sc.nextInt();
			}
			
			int cnt = 0;
			
			// start를 차롇대로 증가시키며 반복
			for(int i = 0; i <arr1.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					if(arr1[i] > arr2[j]) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}