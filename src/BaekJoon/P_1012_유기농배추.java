package BaekJoon;

import java.util.*;

public class P_1012_유기농배추 {
    static int M,N,K;
    static int arr[][];
    static boolean visit[][];
    static int moveX[] = {0,1,0,-1};
    static int moveY[] = {-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N][M];
            visit = new boolean[N][M];
            int cnt = 0;
            
            for(int i=0; i<K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            }
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 1 && !visit[i][j]) {
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(j,i));
        visit[i][j] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int y = p.y;
            int x = p.x;
        
            for(int d=0; d<4; d++) {
                int newY = y + moveY[d];
                int newX = x + moveX[d];
            
                if(0<=newY && newY<N && 0<=newX && newX<M) {
                    if(arr[newY][newX] == 1 && !visit[newY][newX]) {
                        visit[newY][newX] = true;
                        queue.add(new Point(newX,newY));
                    }
                }
            }
        }
    }
    
    static class Point {
    	int x, y;
    	public Point(int x, int y) {
    		this.x=x;
    		this.y=y;
    	}
    }
}