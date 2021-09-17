package BaekJoon;

import java.util.*;

public class P_1600_말이되고픈원숭이 {

	static int K,W,H;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[] d_dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] d_dy= {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();	// 원숭이가 말처럼 움직일 수 있는 횟수
		int W = sc.nextInt();
		int H = sc.nextInt();
		arr = new int[W][H];
		visited = new boolean[W][H][K];
		
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int k = 0; k < K; k++) {
			visited[0][0][k] = true;
		}
		
		if(H==1 && W==1)
			System.out.println(0);
		else
			System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,0,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.remove();
			
			if(cur.x==H-1 && cur.y==W-1)
				return cur.cnt;
			
			// 말처럼 움직일 수 있는 경우	
			if(cur.k<K) {
				for (int j = 0; j < 8; j++) {
					int X = cur.x + d_dx[j];
					int Y = cur.y + d_dy[j];
					if(X>=0 && X<H && Y>=0 && Y<W) {
						if(!visited[X][Y][cur.k+1] && arr[X][Y]==0) {
							visited[X][Y][cur.k+1] = true;
							q.add(new Node(X, Y, cur.k+1, cur.cnt+1));
						}
					}
				}
			}
			
			// 말처럼 움직일 수 없는 경우
			for (int i = 0; i < 4; i++) {
				int X = cur.x + dx[i];
				int Y = cur.y + dy[i];
			
				if(X>=0 && X<H && Y>=0 && Y<W) {
					if(!visited[X][Y][cur.k] && arr[X][Y]==0) {
						visited[X][Y][cur.k] = true;
						q.add(new Node(X, Y, cur.k, cur.cnt+1));
					}
				}
			}
		}
		return -1;
	}
	
	private static class Node{
		private int x;
		private int y;
		private int k;		// 원숭이가 말처럼 움직일 수 있는 횟수
		private int cnt;	// 전체 이동 횟수
		
		public Node(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
}