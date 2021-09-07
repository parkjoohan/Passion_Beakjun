package BaekJoon;

import java.util.*;

public class P_2740_행렬곱셈 {

	static int N,M,K;
	static int[][] arr1;
	static int[][] arr2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr1 = new int[N][M];
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				arr1[i][j]=sc.nextInt();
		
		M = sc.nextInt();
		K = sc.nextInt();
		int[][] arr2 = new int[M][K];
		for(int i=0; i<M; i++)
			for(int j=0; j<K; j++)
				arr2[i][j]=sc.nextInt();
		
		int[][] result = new int[N][K];
		for(int i=0; i<N; i++)
			for(int j=0; j<K; j++)
				for(int r=0; r<M; r++)
					result[i][j] += arr1[i][r] * arr2[r][j];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				System.out.print(result[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}