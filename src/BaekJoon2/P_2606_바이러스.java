package BaekJoon2;

import java.util.*;

public class P_2606_바이러스 {

	static int N, M, cnt=0;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 컴퓨터 수 (정점)
		M = sc.nextInt();	// 연결된 컴퓨터의 쌍의 수 (간선)
		map = new int[N+1][N+1];	// 각 정점 탐색 경로를 저장할 배열
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		
		bfs();
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[1] = true;
		q.offer(1);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			// 차례대로 1번과 연결된 컴퓨터들을 찾아 cnt변수 증가
			for (int i = 1; i < map.length; i++) {
				if(map[x][i]==1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
