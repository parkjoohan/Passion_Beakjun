package BaekJoon2;

import java.util.*;

public class P_1926_그림 {

	static int n, m;
	static int[][] map;
	static int cnt, res, result=0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map= new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
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

	public static void dfs(int r, int c) {
		map[r][c]=0;
		res++;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr>=0 && nc>=0 && nr<n && nc<m &&map[nr][nc]==1) 
				dfs(nr,nc);
		}
	}
}