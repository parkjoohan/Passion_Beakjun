package BaekJoon;

import java.util.*;

public class P_2775_부녀회장이될테야 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			arr[i][1]=1;
			arr[0][i]=i;
		}
		
		for (int i = 0; i < T; i++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			for (int j = 1; j <= K; j++) {
				for (int k = 2; k <= N; k++) {
					arr[j][k] = arr[j-1][k]+arr[j][k-1];
				}
			}
			System.out.println(arr[K][N]);
		}
	}
}