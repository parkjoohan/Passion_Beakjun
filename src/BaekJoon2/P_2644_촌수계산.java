package BaekJoon2;

import java.util.*;
 
public class P_2644_촌수계산 {
    static int n,m,start,end;
    static int result = 0;
    static int[][] map;
    static boolean[] visited;
    static int[] far;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n][n];
        far = new int[n];
        visited = new boolean[n];
        //입력이 1부터 시작이라서 -1을 해줬다.
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            map[a-1][b-1] = 1;
            map[b-1][a-1] = 1;
        }
        
        bfs(start-1, end-1);
        
        //경로가 0이 나온다면 -1을 출력한다.
        if(far[end-1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(far[end-1]);
        }
    }
    //bfs를 통해 경로를 구해준다.
    static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        
        loop: while(!q.isEmpty()) {
            int v = q.poll();
            
            if(v == end) {
                break loop;
            }
            
            for(int i=0; i<n; i++) {
                if(map[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    far[i] = far[v] + 1;
                }
            }
        }
    }
}