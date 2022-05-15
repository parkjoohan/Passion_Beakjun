package BaekJoon2;

import java.util.*;

public class P_1012_유기농배추 {
	
	static int T, N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[M][N];
			visited = new boolean[M][N];
			int cnt=0;
			
			for (int i = 0; i < K; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr>=0 && nc>=0 && nr<M && nc<N) {
				if(map[nr][nc]==1 && !visited[nr][nc])
					dfs(nr, nc);
			}
		}
	}
}