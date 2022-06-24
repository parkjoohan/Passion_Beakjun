package BaekJoon2;

import java.util.*;

public class Main {

	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1,-1,1,-1,1};
	static int[] dy = {1,-1,0,0,-1,1,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt=0;
			
			if(w==0 && h==0)
				System.exit(0);
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<h && ny<w) {
				if(map[nx][ny]==1 && !visited[nx][ny]) 
					dfs(nx,ny);
			}
		}
	}
}