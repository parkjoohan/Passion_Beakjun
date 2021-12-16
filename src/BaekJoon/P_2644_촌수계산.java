package BaekJoon;

import java.util.*;

public class P_2644_촌수계산 {

	static int N, M, num1, num2;
	static int res = -1;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>() ;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		dfs(num1 ,num2, 0);
		System.out.println(res);
	}

	public static void dfs(int r, int c, int cnt) {
		visited[r] = true;
		
		for (int i : list.get(r)) {
			if(!visited[i]) {
				if(i==c) {
					res = cnt+1;
					return;
				}
				dfs(i, c, cnt+1);
			}
		}
	}
}