package BaekJoon;

import java.util.*;

public class p_14502_연구소 {

	static int N, M;
    static int[][] map;
    static int max = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        
        for(int i = 0; i< N; i++) {
            for(int j = 0; j < M; j++) {
            	map[i][j] = sc.nextInt();
            }
        }
        wall(0, 0);
        System.out.println(max);
    }
    
    // 바이러스 존재 여부 확인 후 DFS로 퍼뜨리기
    public static void find(int[][] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 2) dfs(arr, i, j);
            }
        }
    }
    
    // 바이러스 퍼뜨리기(DFS)
    public static void dfs(int[][] arr, int x, int y) {
        for(int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if(X >= 0 && Y >= 0 && X < N && Y < M) {
                if(arr[X][Y] == 0) {
                    arr[X][Y] = 2;
                    dfs(arr, X, Y);
                }
            }
        }
    }
    
    //안전 영영 구하기
    public static int safeArea(int[][] arr) {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    
    // 벽 위치 정하기(조합)
    public static void wall(int idx, int x) {
        if(idx == 3) {
            int[][] arr = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    arr[i][j] = map[i][j];
                }
            }
            find(arr); //바이러스가 퍼진다.
            max = Math.max(max, safeArea(arr));
            return;
        }
        
        for(int i = x; i < N * M; i++) {
            int X = i / M;
            int Y = i % M;
            if(map[X][Y] == 0) {
            	// 벽 세우기
            	map[X][Y] = 1; 
            	wall(idx + 1, i + 1);
            	// 벽 부수기
                map[X][Y] = 0; 
            }
        }
    }
}