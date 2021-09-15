package BaekJoon;

import java.util.Scanner;

public class P_2606_바이러스 {

	static int N, M, cnt=0;
	static int[][] map;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();			// 컴퓨터 수
		M = sc.nextInt();			// 연결된 컴퓨터 쌍의 수(간선)
		map = new int[N+1][N+1];	// 각 정점간 탐색 경로를 저장할 배열
		visit = new boolean[N+1];	// 정점의 탐색 여부 체크
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		System.out.println(dfs(1));
	}

	private static int dfs(int start) {
		visit[start] = true;
		
		for (int i = 1; i <= N; i++) {
			if(map[start][i]==1 && !visit[i]) {
				cnt++;
				dfs(i);
			}
		}
		return cnt;
	}
}