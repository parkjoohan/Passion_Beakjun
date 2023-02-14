package BaekJun_Study;

import java.util.*;

public class N과M4 {

	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		
		dfs(1,0);
	}
	
	public static void dfs(int index, int depth) {
		if(depth == M) {
			for(int val : arr)
				System.out.print(val + " ");
			System.out.println();
			return;
		}
		
		for(int i=index; i<=N; i++) {
			arr[depth] = i;
			dfs(i, depth+1);
		}
	}
}