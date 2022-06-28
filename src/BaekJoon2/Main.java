package BaekJoon2;

import java.util.*;

public class Main {

	static int N, M, cnt, res, result=0;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					res=0;
					dfs(i,j);
					cnt++;
					result = Math.max(result, res);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(result);
	}
	
	public static void dfs(int x, int y) {
		
		map[x][y]=0;
		res++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==1)
				dfs(nx, ny);
		}
	}
}