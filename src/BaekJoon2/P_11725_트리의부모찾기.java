package BaekJoon2;

import java.util.*;

public class P_11725_트리의부모찾기 {

	static int N;
	static int[] result;
	static boolean[] visited;
	static List<Integer> list[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		
		for (int i : list[v]) {
			if(!visited[i]) {
				result[i] = v;
				dfs(i);
			}
		}
	}
}