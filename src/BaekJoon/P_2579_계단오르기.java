package BaekJoon;

import java.util.*;

public class P_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			// 첫번째 칸은 그냥 합하면 됨
			if(i==1)
				dp[i] = arr[1];
			// 두번째 칸 까지는 연속 밟기 가능
			else if(i==2)
				dp[i] = arr[1] + arr[2];
			// 세번 연속 밟기는 불가. 따라서 경우의 수를 나눈다. 
			// 1. 첫번째 칸 밟고 두 칸 띄어 밟기
			// 2. 두 칸 우선 띄어 밝고 연속 밟기
			else
				dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
		}
		System.out.println(dp[N]);
	}
} 