//package BaekJoon2;
//
//import java.util.*;
//
//public class P_2178_미로탐색 {
//    
//	static int N, M;
//	static int[][] map;
//	static boolean[][] visited;
//	static int[] dx = {0,1,0,-1};
//	static int[] dy = {1,0,-1,0};
//    public static void main(String[] args) {
//    	Scanner sc = new Scanner(System.in);
//    	N = sc.nextInt();
//    	M = sc.nextInt();
//    	map = new int[N][M];
//    	visited = new boolean[N][M];
//    	
//    	for (int i = 0; i < N; i++) {
//    		String str = sc.next();
//			for (int j = 0; j < M; j++) {
//				map[i][j] = str.charAt(j) - '0';
//			}
//		}
//    	
//    	bfs();
//    	System.out.println(map[N-1][M-1]);
//    }
//    
//    public static void bfs() {
//    	
//    	// x, y에 대한 Queue
//    	Queue<Integer> q_x = new LinkedList<Integer>();
//    	Queue<Integer> q_y = new LinkedList<Integer>();
//    	
//    	// 저장
//    	q_x.offer(0);
//    	q_y.offer(0);
//    	
//    	visited[0][0] = true;
//    	
//    	while(!q_x.isEmpty()) {
//    		int x = q_x.poll();
//    		int y = q_y.poll();
//    		
//    		// 상하좌우 확인
//    		for (int k = 0; k < 4; k++) {
//				int temp_x = x + dx[k];
//				int temp_y = y + dy[k];
//				
//				// 유효한 범위인지 확인
//				if(temp_x >= 0 && temp_y >= 0 && temp_x < N && temp_y < M) {
//					if(map[temp_x][temp_y]==1 && visited[temp_x][temp_y]==false) {
//						q_x.offer(temp_x);
//						q_y.offer(temp_y);
//						
//						visited[temp_x][temp_y] = true;
//						
//						map[temp_x][temp_y] = map[x][y] + 1;
//					}
//				}
//			}
//    	}
//    }
//}

package BaekJoon2;

import java.util.*;

public class P_2178_미로탐색 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		visited[0][0]=true;
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		dfs(0,0);
		System.out.println(map[N-1][M-1]);
	}
	
	public static void dfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] d = q.poll();
			int xx = d[0];
			int yy = d[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = xx + dx[i];
				int ny = yy + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0)
					continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny]=true;
				map[nx][ny]=map[xx][yy]+1;
			}
		}
	}
}