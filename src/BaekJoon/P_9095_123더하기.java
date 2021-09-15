package BaekJoon;

import java.util.Scanner;

public class P_9095_123더하기 {

static int dp[] = new int [11];
	static int T, N;
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			
			dp[1]=1; //초기 값 초기화
			dp[2]=2;
			dp[3]=4;
			
			for(int j=4;j<=10;j++) { // 4부터 반복
				dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; // 점화식
			}
			System.out.println(dp[N]);	
		}		
	}
} 