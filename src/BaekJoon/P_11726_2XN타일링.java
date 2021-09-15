package BaekJoon;

import java.util.*;

public class P_11726_2XN타일링 {

	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[N+2];
		
		dp[0]=0; //초기 값 초기화
		dp[1]=1;
		dp[2]=2;
			
		for(int j=3;j<=N;j++) { // 4부터 반복
			dp[j] = (dp[j-2] + dp[j-1])%10007; // 점화식
		}
		System.out.println(dp[N]);		
	}
} 