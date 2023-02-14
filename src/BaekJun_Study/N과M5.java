package BaekJun_Study;

import java.util.*;

public class N과M5 {

	static int N, M;
	static int[] nums;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		arr = new int[M];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) 
			nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		dfs(0);
	}

	public static void dfs(int depth) {
		if(depth == M) {
			for(int val : arr) 
				System.out.print(val + " ");
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = nums[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}
