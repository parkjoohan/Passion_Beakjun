package BaekJoon;

import java.util.*;

public class P_4485_녹색옷입은애가젤다지 {

	static int N;
	static int INF = Integer.MAX_VALUE;
	static int[][] map, dist;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (true) {
            N = sc.nextInt();
            if(N==0) return;
            
            map = new int[N][N];
            dist = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    dist[i][j] = INF;
                }
            }
            System.out.println("Problem " + (++cnt) + ": " + dijkstra());
        }
    }

	public static int dijkstra() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, map[0][0]));
        dist[0][0] = map[0][0];
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                if (X >= 0 && Y >= 0 && X < N && Y < N && (dist[X][Y] > dist[x][y] + map[X][Y])) { 
                	dist[X][Y] = dist[x][y] + map[X][Y];
                    queue.add(new Point(X, Y, dist[X][Y]));
                }
            }
        }
        return dist[N - 1][N - 1];
    }
	
	static class Point implements Comparable<Point> {
		int x, y, w;
		public Point(int x, int y, int w) {
			super();
			this.x=x;
			this.y=y;
			this.w=w;
		}
		@Override
		public int compareTo(Point o) {
			int diff = this.w-o.w;
			return diff;
		}
	}
}
