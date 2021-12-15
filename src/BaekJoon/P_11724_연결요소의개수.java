package BaekJoon;

import java.util.*;

//public class P_11724_연결요소의개수 {
//	static int N;	// 정점
//	static int M;	// 간선
//	static int count;		// 연결 요소의 개수
//	static int graph[][];	// 무방향 그래프 
//	static boolean visit[];	// 방문 여부 체크
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		graph = new int[N+1][N+1]; 
//		visit = new boolean[N+1];
//
//		for(int i=1; i<=M; i++) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			graph[a][b] = graph[b][a] = 1;
//		}
//		
//		for(int i=1; i<=N; i++) {
//			if(!visit[i]) {
//				bfs(i);
//				count ++;
//			}
//		}
//		System.out.println(count);
//	}
//	
//	public static void bfs(int i) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.offer(i);
//		visit[i] = true;
//		
//		while(!q.isEmpty()) {
//			int temp = q.poll();
//			for(int j=1; j<=N; j++) {
//				if(graph[temp][j] == 1 && visit[j] == false) {
//					q.offer(j);
//					visit[j] = true;
//				}
//			}
//		}
//	}
//}

public class P_11724_연결요소의개수 {
	
	static int N, M;
	static int cnt;
	static int graph[][];
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for (int j = 1; j <= N; j++) {
				if(graph[tmp][j] == 1 && !visited[j]) {
					q.offer(j);
					visited[j] = true;
				}
			}
		}
	}
}
