package BaekJoon2;

import java.util.*;

public class P_9461_파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[101];
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}