package BaekJoon2;

import java.util.*;

public class P_1010_다리놓기 {

	static int T, N, M;
	static int[][] dp = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			sb.append(func(M, N)).append('\n');
		}
		System.out.println(sb);
	}

	public static int func(int cnt, int start) {
		
		if(dp[cnt][start] > 0) {
			return dp[cnt][start]; 
		}
				
		if(cnt == start || start == 0) {
			return dp[cnt][start] = 1;
		}
				
		return dp[cnt][start] = func(cnt - 1, start - 1) + func(cnt - 1, start);
	}
}