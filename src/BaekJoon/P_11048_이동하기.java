package BaekJoon;

import java.util.Scanner;

public class P_11048_이동하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
				
				int max = Math.max(arr[i][j-1], Math.max(arr[i-1][j-1], arr[i-1][j]));
				arr[i][j] += max;
			}
		}
		System.out.println(arr[N][M]);
	}
} 