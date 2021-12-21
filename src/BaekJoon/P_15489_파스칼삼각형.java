package BaekJoon;

import java.util.*;

public class P_15489_파스칼삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dp[][] = new int[31][31];
		int R = sc.nextInt();
		int C = sc.nextInt();
		int W = sc.nextInt();
		int sum=0;
		dp[1][1]=1;
		
		for (int i = 1; i <= 30; i++) {
			for (int j = 1; j <= i; j++) {
				if(i==j || j==1)
					dp[i][j]=1;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < i+1; j++) {
				sum+=dp[R+i][C+j];
			}
		}
		System.out.println(sum);
	}
} 