package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class P_15664_N과M {
	static int N, M;
	public static int[] arr;
	public static int[] result;
	public static boolean[] check;

	static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		M = sc.nextInt();
 
		arr = new int[N];
		result = new int[M];
		check = new boolean[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		Result(0, 0);
		System.out.println(sb);
	}
 
	public static void Result(int start, int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) 
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				result[idx] = arr[i];
				Result(i, idx + 1);
				check[i] = false;
			}
		}
	}
}