package BaekJoon;

import java.util.*;

public class P_1753_최단경로 {
	
	static class Edge{
		int vertex;
		int weight;
		Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt()-1;
		List<Edge>[] adj = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Edge>(); 
		}
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt()-1;
			int to = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			adj[from].add(new Edge(to, weight));
		}
		
		// 다익스트라
		boolean[] check = new boolean[V];
		// 거리 저장 배열
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		for (int i = 0; i < V; i++) {
			// 방문하지 않았으며 dist 값이 제일 작은 정점 번호 찾기
			int min = Integer.MAX_VALUE;
			int index=-1;
			for (int j = 0; j < V; j++) {
				if(!check[j] && min>dist[j]) {
					min=dist[i];
					index=j;
				}
			}
			// 찾아진 정점이 없다는 것은 더이상 경로가 존재하지 않음을 의미
			if(index==-1)	break;
			check[index]=true;
			
			// 이 정점으로부터 모든 경로 탐색
			for(Edge next : adj[index]) {
				if(check[next.vertex])	continue;
				if(dist[next.vertex]>dist[index]+next.weight)
					dist[next.vertex]=dist[index]+next.weight;
			}
		}
		
		for (int i = 0; i < V; i++) {
			if(dist[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
}
