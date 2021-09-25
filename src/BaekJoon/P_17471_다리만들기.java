package BaekJoon;

import java.util.*;

public class P_17471_다리만들기{
    static int N;
    static int[][] graph;
    static int[][] island;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0 ,1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        Queue<Map> s = new LinkedList<>();
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                graph[i][j] = sc.nextInt();
                // 섬 부분을 모두 Queue에 추가해둔다.
                if(graph[i][j] == 1) 
                	s.offer(new Map(i, j));
            }
        }

        // ***************** 섬 마다 구분하기 위해 다른 번호로 저장 ***************
        Queue<Map> q = new LinkedList<>();
        island = new int[N][N];
        distance = new int[N][N];
        visited = new boolean[N][N];
        int cnt = 1;
        
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(visited[i][j] || graph[i][j] == 0) continue;
                q.offer(new Map(i, j));
                visited[i][j] = true;

                // 연결된 섬의 정보를 모두 체크(각 섬을 다른 번호로 저장)
                while(!q.isEmpty()){
                    Map u = q.poll();
                    island[u.y][u.x] = cnt;

                    for(int k=0; k < 4; k++){
                        int ny = u.y + dy[k];
                        int nx = u.x + dx[k];

                        if(0 <= ny && ny < N && 0 <= nx && nx < N 
                        	&& !visited[ny][nx] && graph[ny][nx] == 1){
                            visited[ny][nx] = true;
                            q.offer(new Map(ny, nx));
                        }
                    }
                }
                cnt++;
            }
        }
        
        // ******************* 현재 섬 주변의 모든 바다를 동일 섬 번호로 메꿈 *************
        while(!s.isEmpty()){
            Map u = s.poll();
            for(int i=0; i < 4; i++){
                int ny = u.y + dy[i];
                int nx = u.x + dx[i];

                // 위치에 있고 방문되지 않았다면 섬이 아니라 바다이므로 작업 수행
                if(0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    s.offer(new Map(ny, nx));
                    
                    // 섬으로 부터의 거리를 저장(이전의 +1)
                    distance[ny][nx] = distance[u.y][u.x] + 1;
                    
                    // 섬 값으로 동일하게 지정
                    island[ny][nx] = island[u.y][u.x];
                }
            }
        }
        
        // ****************** 인접한 정점 중 번호가 다른 것의 거리 계산 *****************
        int ans = -1;
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                for(int k=0; k < 4; k++){
                    int ni = i + dy[k];
                    int nj = j + dx[k];
                    if(0 <= ni && ni < N && 0 <= nj && nj < N 
                    	&& island[i][j] != island[ni][nj]){
                        // 인접 정점의 번호가 다르면, 그 거리를 더하면 다리의 길이가 됨(섬 간 연결)
                        if(ans == -1 || ans > distance[i][j] + distance[ni][nj]){
                            ans = distance[i][j] + distance[ni][nj];
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

class Map{
    int y;
    int x;
    public Map(int y, int x){
        this.y = y;
        this.x = x;
    }
}