package BaekJoon2;

import java.util.*;

public class P_1890_점프 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		
		dp[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 넘어가는 경우 : dp[i][j] == 0, 마지막인 경우
				if(dp[i][j] == 0 || (i == N-1 && j == N-1))	continue;
				
				int dist = map[i][j];
				int down = dist + i;
				int right = dist + j;
				
				if(down < N)	dp[down][j] += dp[i][j];
				if(right < N)	dp[i][right] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}
}