package BaekJoon2;

import java.util.*;

public class 촌수계산 {
	static int N, A, B, M;
	static int[][] map;
	static int[] cnt;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][N+1];
		cnt = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = map[y][x] = 1;
		}
		
		bfs(A, B);
		
		if(cnt[B]==0)	System.out.println(-1);
		else	System.out.println(cnt[B]);
	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x == end)	return;
			
			for (int i = 1; i < N; i++) {
				if(map[x][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i] = true;
					cnt[i] = cnt[x] + 1;
				}
			}
		}
	}
}