package BaekJoon2;

import java.util.*;

public class P_11724_연결요소의개수 {

	static int N, M;
	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		int cnt=0;
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		// 방문 배열 돌면서 방문하지 않은 정점이 있으면 탐색하고 연결요소 개수 1 증가
		for (int i = 1; i <= N; i++) {
			if(visit[i]==false) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int index) {
		visit[index] = true;
		
		// 방문 배열 처음부터 돌면서 간선이 연결되어 있고, 방문하지 않았으면 dfs 탐색
		for (int i = 1; i <= N; i++) {
			if(arr[index][i]==1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}