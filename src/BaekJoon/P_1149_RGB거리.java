package BaekJoon;

import java.util.Scanner;

public class P_1149_RGB거리 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][3];
		
		for (int i = 1; i < dp.length; i++) {
			int R = sc.nextInt();
			int G = sc.nextInt();
			int B = sc.nextInt();
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+R;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+G;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+B;
		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}