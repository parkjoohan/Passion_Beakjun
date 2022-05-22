package BaekJoon2;

import java.util.*;

public class P_2468_안전영역 {
	
	static int N;	
	static int map[][];			
	static boolean visit[][];	
	static int[] dx = {0, -1, 0, 1};	
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		// 배열의 정수 중 높이 최댓값 
		int max = 0;		
		// 안전영역이 최대인 갯수
		int result = 1;	
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				// 최대 높이 저장
				if(map[i][j] > max)	
					max = map[i][j];
			}
		}
		
		// 1부터 최대 높이만큼까지 안전영역이 최대인 갯수 찾기.
		for(int i=1; i<=max; i++) {	
			// 각 높이마다 방문 영역 초기화
			visit = new boolean[N][N];	
			// 각 높이마다 안전영역의 갯수 초기화
			int count = 0;	
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					// 잠기지 않는곳 && 방문하지 않은 곳
					if(map[j][k] > i && !visit[j][k]) {
						count ++;
						dfs(j, k, i);
					}
				}
			}
			// i 높이의 모든 탐색이 끝나면 이전과 비교해 크기가 최대인 영역 구하기.
			result = Math.max(result, count);	
		}
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int h) {
		
		// x, y 좌표가 지도의 범위를 벗어났을경우
		if(x<0 || x>=N || y<0 || y>=N)
			return;
		
		// 이미 방문한 위치 OR 높이 이하(물에 잠긴)인 경우.
		if(visit[x][y] || map[x][y] <=h)	
			return;
		
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 해당 지도의 범위 이내여야함.
			if(nx>=0 && ny>=0 && nx<N && ny<N) {	
				// 안잠기는곳 && 방문하지 않은 곳
				if(map[nx][ny] > h && visit[nx][ny] == false)	
					dfs(nx, ny, h);	// dfs 호출
			}
		}
	}
}