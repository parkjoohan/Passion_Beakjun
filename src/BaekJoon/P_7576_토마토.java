package BaekJoon;

import java.util.*;
public class P_7576_토마토 {

	static int N, M, cnt=0; 
	static int max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(max);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
 
		while (!q.isEmpty()) { 
			int[] R = q.poll();
			
			// 동, 서, 남, 북 탐색
			for (int i = 0; i < 4; i++) { 
				int X = R[0] + dx[i];
				int Y = R[1] + dy[i];
 
				// 미로 밖, 벽, 이미 탐색을 한 곳 제외
				if (X<0 || X>=N || Y<0 || Y>=M || visited[X][Y] || arr[X][Y] == 0) 
					continue;
 
				// 다음 탐색 지점을 큐에 추가
				q.add(new int[] { X, Y });
				// 다음 탐색 지점 탐색처리
				visited[X][Y] = true;
				// 다음 탐색 지점의 비용을 현재 좌표 + 1 로 변경
				arr[X][Y] = arr[R[0]][R[1]] + 1;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		
	}
}