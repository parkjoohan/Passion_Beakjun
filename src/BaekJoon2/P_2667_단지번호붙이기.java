package BaekJoon2;

import java.util.*;

public class P_2667_단지번호붙이기 {

	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt=1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int num : list)
			System.out.println(num);
	}
	
	public static int dfs(int x, int y) {
		visited[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					dfs(nx, ny);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}