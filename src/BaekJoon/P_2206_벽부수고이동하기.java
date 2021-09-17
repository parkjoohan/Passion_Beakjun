package BaekJoon;

import java.util.*;

public class P_2206_벽부수고이동하기 {

	static int N, M;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.valueOf(str.charAt(j)) - '0';
			}
		}
		System.out.println(bfs(0,0));
	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,0,0));
		visited[x][y][0] = true;
		visited[x][y][1] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.x==N-1 && cur.y==M-1)
				return cur.cnt;
			
			for (int i = 0; i < 4; i++) {
				int X = cur.x + dx[i];
				int Y = cur.y + dy[i];
				
				if(X>=0 && X<N && Y>=0 && Y<M) {
					// 벽이 아닐 때
					if(arr[X][Y]==0) {
						// 방문한적 없다면 방문
						if(visited[X][Y][cur.breaking] == false) {
							q.add(new Node(X, Y, cur.cnt+1, cur.breaking));
							visited[X][Y][cur.breaking]= true; 
						}
					}
					// 벽일 때
					else if(arr[X][Y]==1) {
						// 벽 부수지 않았고 방문한 적도 없다.
						if(cur.breaking==0 && visited[X][Y][1]==false) {
							q.add(new Node(X, Y, cur.cnt+1, 1));
							visited[X][Y][1]= true; 
						}
					}
				}
			}
		}
		return -1;
	}

	private static class Node{
		private int x;
		private int y;
		private int cnt;
		// 벽을 부쉈는지. 0이면 안 부쉈고, 1이면 부쉈다.
		private int breaking;
		
		public Node(int x, int y, int cnt, int breaking) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.breaking = breaking;
		}
	}
}
