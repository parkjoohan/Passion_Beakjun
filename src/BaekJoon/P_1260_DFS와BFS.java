package BaekJoon;

import java.util.*;

public class P_1260_DFS와BFS {
 
	static int N, M, V;
	static boolean[] visits;	// 확인 여부
	static int[][] map;			// 간선 연결상태
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		visits = new boolean[N+1];
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b]=1;
			map[b][a]=1;
		}
		dfs(V);
		System.out.println();
		visits = new boolean[N+1];
		bfs(V);
	}
    
    private static void dfs(int start) {
    	visits[start] = true;
    	System.out.print(start+" ");
    	for (int i = 1; i <= N; i++) {
			if(map[i][start] == 1 && !visits[i])
				dfs(i);
		}
    }
    
    private static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.offer(start);
    	//Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
    	while(!q.isEmpty()) {
    		int out = q.poll();
    		visits[out] = true;
    		System.out.print(out+" ");
    		for (int i = 1; i <= N; i++) {
				if(map[i][out] == 1 && !visits[i] && i!=out) {
					q.offer(i);
					visits[i]=true;
				}
			}
    	}
    }
}
