package BaekJun_Study;

import java.util.*;

public class N과M3 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		dfs(0);
		
		System.out.print(sb);
	}

	public static void dfs(int depth) {
		if(depth == M) {
			for(int val : arr)
				sb.append(val + " ");
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[depth] = i;
			dfs(depth+1);
		}
	}
}