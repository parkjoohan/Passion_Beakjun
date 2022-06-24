package BaekJoon2;

import java.util.*;

public class P_2468_안전영역 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		// 배열 정수 중 높이 최댓값
		int max = 0;
		// 안전영역 최대인 갯수
		int result = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]>max)
					max = map[i][j];
			}
		}
		
		// 1부터 최대 높이까지 안전영역이 최대인 갯수 찾기
		for(int i=1; i<=max; i++) {
			// 각 높이마다 방문 영역 초기화
			visited = new boolean[N][N];
			// 각 높이마다 안전영역의 갯수 초기화
			int cnt=0;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					// 잠기지 않고 방문하지 않은 곳
					if(map[j][k]>i && !visited[j][k]) {
						cnt++;
						dfs(j,k,i);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int h) {
		
		// x, y 좌표가 지도의 범위를 벗어나는 경우
		if(x<0 || y<0 || x>=N || y>=N)
			return;
		
		// 이미 방문한 위치거나 최대 높이 이하로 잠긴 경우
		if(visited[x][y] || map[x][y]<=h)
			return;
		
		visited[x][y]=true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 해당 지도 내여야함
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				// 잠기지 않고 방문하지 않은 곳
				if(!visited[nx][ny] && map[nx][ny]>h)
					dfs(nx,ny,h);
			}
		}
	}
}