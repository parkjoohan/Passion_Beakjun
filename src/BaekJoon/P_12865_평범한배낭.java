package BaekJoon;

import java.util.*;

public class P_12865_평범한배낭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] D = new int[N+1][W+1];
		
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= W; w++) {
				if(weights[i] <= w) 
					D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
				else
					D[i][w] = D[i-1][w];
			}
		}
		System.out.println(D[N][W]);
	}
}