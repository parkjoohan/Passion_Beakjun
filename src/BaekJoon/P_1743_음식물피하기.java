package BaekJoon;

import java.util.*;

public class P_1743_음식물피하기 {
	 public static int N, M, K;
	 public static int[][] map;
	 public static boolean[][] visited;
	 public static int result;
	 public static int[] dx = {-1, 0, 1, 0};
	 public static int[] dy = {0, -1, 0, 1};

	 public static void main (String[] args) {
		 Scanner sc = new Scanner(System.in);
	     N = sc.nextInt();
	     M = sc.nextInt();
	     K = sc.nextInt();
	     map = new int[N+1][M+1];
	     visited = new boolean[N+1][M+1];

	     for (int i = 1; i <= K; i++) {
	    	 int a = sc.nextInt();
	         int b = sc.nextInt();
	         map[a][b] = 1;
	     }
	        
	     for (int i = 1; i <= N; i++) {
	         for (int j = 1; j <= M; j++) {
	        	 if (map[i][j] == 1 && !visited[i][j]) {
	        		 int temp = result;
	                 result = 0;
	                 dfs(i, j);
	                 result = Math.max(result, temp);
	             }
	         }
	     }
	     System.out.println(result);
	 }
	    
	 public static void dfs(int r, int c){
	     visited[r][c] = true;
	     result++; // 방문할 때마다 개수 추가

	     for (int d = 0; d < 4; d++) {
	    	 int R = r + dx[d];
	         int C = c + dy[d];

	         if(R < 1 || C < 1 || R>=N+1 || C>=M+1) continue;
	         else if (map[R][C] == 1 && !visited[R][C])
	             dfs(R, C);
	     }
	 }
}